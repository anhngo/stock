package controllers.services;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.beans.TickerDim;
import controllers.beans.TickerFact;
import controllers.libs.Constant;
import controllers.libs.Utils;
import controllers.requests.TickerRequest;
import play.libs.F;
import play.libs.ws.WS;
import play.libs.ws.WSResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anhngo on 4/29/15.
 */
public class TickerServiceImpl implements ITickerService {
    @Override
    public F.Promise<List<TickerDim>> getTickersList(final TickerRequest request) {
        String nasdaqUrl = Constant.NASDAQ_COMPANIES_LISTING_URL;
        return WS.url(nasdaqUrl).get().<List<TickerDim>>map(
                new F.Function<WSResponse, List<TickerDim>>() {
                    @Override
                    public List<TickerDim> apply(WSResponse wsResponse) throws Throwable {
                        String body = wsResponse.getBody();
                        List<TickerDim> tickers = new ArrayList<>();
                        int lineCount = 0;
                        for (String line : body.split("\n")) {
                            // skip the header line
                            if (lineCount == 0) {
                                lineCount += 1;
                                continue;
                            }
                            line = line.substring(1, line.length() - 3);
                            String[] items = line.split("\",\"");
                            if (items.length == 8) {
                                TickerDim tickerDim =
                                        TickerDim.build(
                                                items[0]
                                                , items[1]
                                                , Utils.parseMarketCapTypeFromNasdaq(items[3])
                                                , "n/a".equals(items[4]) ? null : new Integer(items[4])
                                                , items[5]
                                                , items[6]
                                        );

                                // applying filter
                                boolean isIncluded = true;
                                if (request.isPublic != null) {
                                    isIncluded = request.isPublic == (tickerDim.ipoYear != null);
                                }
                                if (request.marketCapType != null) {
                                    isIncluded = isIncluded && request.marketCapType.equals(tickerDim.marketCapType);
                                }

                                if (isIncluded) {
                                    tickers.add(tickerDim);
                                }
                            }
                        }
                        return tickers;
                    }
                }
        );
    }

    @Override
    public F.Promise<TickerFact> getTicker(final TickerRequest request) {
        String financeUrl = String.format("%s/symbol/%s?view=detail&format=json", Constant.YAHOO_FINANCE_BASE_URL, request.symbol);
        return WS.url(financeUrl).get().<TickerFact>map(
                new F.Function<WSResponse, TickerFact>() {
                    @Override
                    public TickerFact apply(WSResponse wsResponse) throws Throwable {
                        JsonNode tickersJArray = wsResponse.asJson().findPath("finance").findPath("quotes").findPath("Quote");
                        TickerFact tickerResult;
                        if (tickersJArray != null && tickersJArray.size() > 0) {
                            tickerResult = TickerFact.build(
                                    tickersJArray.get(0).get("price").asDouble()
                                    , tickersJArray.get(0).get("change").asDouble()
                                    , tickersJArray.get(0).get("chg_percent").asDouble()
                                    , tickersJArray.get(0).get("market_cap").asDouble()
                            );
                        } else {
                            tickerResult = TickerFact.build();
                        }
                        return tickerResult;
                    }
                }
        );
    }
}
