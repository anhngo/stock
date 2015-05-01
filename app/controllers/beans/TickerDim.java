package controllers.beans;

import controllers.libs.Constant.MarketCapType;

/**
 * Created by anhngo on 4/30/15.
 */
public class TickerDim {
    public final String symbol;
    public final String name;
    public final MarketCapType marketCapType;
    public final Integer ipoYear;
    public final String sector;
    public final String industry;

    private TickerDim(
            String symbol
            , String name
            , MarketCapType marketCapType
            , Integer ipoYear
            , String sector
            , String industry
    ) {
        this.symbol = symbol;
        this.name = name;
        this.marketCapType = marketCapType;
        this.ipoYear = ipoYear;
        this.sector = sector;
        this.industry = industry;
    }

    public static TickerDim build(String symbol, String name, MarketCapType marketCapType, Integer ipoYear, String sector, String industry) {
        return new TickerDim(symbol, name, marketCapType, ipoYear, sector, industry);
    }

    public static TickerDim build() {
        return new TickerDim(null, null, null, null, null, null);
    }
}
