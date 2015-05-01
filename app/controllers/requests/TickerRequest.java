package controllers.requests;

import controllers.libs.Constant;

/**
 * Created by anhngo on 4/29/15.
 */
public class TickerRequest {
    public final String symbol;
    public final Constant.MarketCapType marketCapType;
    public final Boolean isPublic;

    public TickerRequest(
            String symbol
            , Constant.MarketCapType markerCapType
            , Boolean isPublic
    ) {
        this.symbol = symbol;
        this.marketCapType = markerCapType;
        this.isPublic = isPublic;
    }
}
