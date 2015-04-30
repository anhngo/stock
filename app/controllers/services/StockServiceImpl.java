package controllers.services;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.beans.Quote;
import controllers.libs.StockConstant;
import controllers.requests.QuoteRequest;
import play.libs.F;
import play.libs.ws.WS;
import play.libs.ws.WSResponse;

/**
 * Created by anhngo on 4/29/15.
 */
public class StockServiceImpl implements IStockService {

    @Override
    public F.Promise<Quote> getQuote(final QuoteRequest request) {
        String financeUrl = String.format("%s/symbol/%s?view=detail&format=json", StockConstant.YAHOO_FINANCE_BASE_URL, request.symbol);
        return WS.url(financeUrl).get().<Quote>map(
                new F.Function<WSResponse, Quote>() {
                    @Override
                    public Quote apply(WSResponse wsResponse) throws Throwable {
                        JsonNode quotesJArray = wsResponse.asJson().findPath("finance").findPath("quotes").findPath("Quote");
                        Quote quoteResult;
                        if (quotesJArray != null && quotesJArray.size() > 0) {
                            quoteResult = new Quote(
                                    quotesJArray.get(0).get("name").asText()
                                    , quotesJArray.get(0).get("symbol").asText()
                                    , quotesJArray.get(0).get("change").asDouble()
                                    , quotesJArray.get(0).get("chg_percent").asDouble()
                                    , quotesJArray.get(0).get("price").asDouble()
                                    , quotesJArray.get(0).get("market_cap").asDouble()
                            );
                        } else {
                            quoteResult = new Quote(
                                    null
                                    , null
                                    , null
                                    , null
                                    , null
                                    , null
                            );
                        }
                        return quoteResult;
                    }
                }
        );
    }
}
