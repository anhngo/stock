package controllers.das;

import controllers.libs.Constant;
import models.beans.da.TickerDimsNasdagBySymbols;
import models.requests.TickersDARequest;
import play.libs.F;
import play.libs.ws.WS;
import play.libs.ws.WSResponse;

/**
 * Created by anhngo on 7/4/15.
 */
public class TickerDimsNasdagBySymbolsDA {

    public F.Promise<TickerDimsNasdagBySymbols> getResult() {
        String nasdaqUrl = Constant.NASDAQ_COMPANIES_LISTING_URL;
        return WS.url(nasdaqUrl).get().<TickerDimsNasdagBySymbols>map(
                new F.Function<WSResponse, TickerDimsNasdagBySymbols>() {
                    @Override
                    public TickerDimsNasdagBySymbols apply(WSResponse wsResponse) throws Throwable {
                        String body = wsResponse.getBody();
                        return TickerDimsNasdagBySymbols.build(body);
                    }
                }
        );
    }
}
