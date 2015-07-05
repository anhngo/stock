package controllers.das;

import controllers.libs.Constant;
import controllers.libs.Utils;
import models.beans.da.TickerMetricsYFinanceBySymbols;
import models.requests.TickersDARequest;

import org.json.JSONArray;
import play.libs.F;
import play.libs.ws.WS;
import play.libs.ws.WSResponse;

/**
 * Created by anhngo on 7/4/15.
 */
public class TickerMetricsYFinanceBySymbolsDA {

    public F.Promise<TickerMetricsYFinanceBySymbols> getResult(final TickersDARequest request) {

        String symbolsList = Utils.listToString(request.symbols);
        String financeUrl = String.format("%s/symbol/%s?view=detail&format=json", Constant.YAHOO_FINANCE_BASE_URL, symbolsList);
        return WS.url(financeUrl).get().<TickerMetricsYFinanceBySymbols>map(
            new F.Function<WSResponse, TickerMetricsYFinanceBySymbols>() {
                @Override
                public TickerMetricsYFinanceBySymbols apply(WSResponse wsResponse) throws Throwable {
                    try {
                        JSONArray tickers = new JSONArray(wsResponse.asJson().findPath("finance").findPath("quotes").toString());
                        return TickerMetricsYFinanceBySymbols.build(tickers);
                    } catch (Exception e) {
                        // TODO: log error msg
                        return TickerMetricsYFinanceBySymbols.build();
                    }
                }
            }
        );
    }
}
