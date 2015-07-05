package models.beans.service;

import controllers.libs.Constant;
import models.beans.da.TickerDimsNasdag;
import models.beans.da.TickerMetricsYFinance;

/**
 * Created by anhngo on 6/17/15.
 */
public class Ticker {

    public final String symbol;

    public final String name;
    public final Constant.MarketCapType marketCapType;
    public final Integer ipoYear;
    public final String sector;
    public final String industry;

    public final Double price;
    public final Double change;
    public final Double changePrcnt;
    public final Double marketCap;

    public Ticker(TickerDimsNasdag tickerDims, TickerMetricsYFinance tickerMetrics) {
        String symbol = null;
        String name = null;
        Constant.MarketCapType marketCapType = null;
        Integer ipoYear = null;
        String sector = null;
        String industry = null;
        Double price = null;
        Double change = null;
        Double changePrcnt = null;
        Double marketCap = null;

        if (tickerDims != null) {
            symbol = tickerDims.symbol;
            name = tickerDims.name;
            marketCapType = tickerDims.marketCapType;
            ipoYear = tickerDims.ipoYear;
            sector = tickerDims.sector;
            industry = tickerDims.industry;
        }

        if (tickerMetrics != null) {
            symbol = symbol == null ? tickerMetrics.symbol : symbol;
            price = tickerMetrics.price;
            change = tickerMetrics.change;
            changePrcnt = tickerMetrics.changePrcnt;
            marketCap = tickerMetrics.marketCap;
        }

        this.symbol = symbol;
        this.name = name;
        this.marketCapType = marketCapType;
        this.ipoYear = ipoYear;
        this.sector = sector;
        this.industry = industry;
        this.price = price;
        this.change = change;
        this.changePrcnt = changePrcnt;
        this.marketCap = marketCap;
    }
}
