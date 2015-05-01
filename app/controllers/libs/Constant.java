package controllers.libs;

/**
 * Created by anhngo on 4/29/15.
 */
public class Constant {
    public static final String YAHOO_FINANCE_BASE_URL = "http://finance.yahooapis.com/v1/quote";
    public static final String NASDAQ_COMPANIES_LISTING_URL = "http://www.nasdaq.com/screening/companies-by-name.aspx?exchange=NASDAQ&render=download";

    public static enum MarketCapType {
        NANO(50.0)
        , MICRO(300.0)
        , SMALL(2000.0)
        , MID(10000.0)
        , LARGE(100000.0)
        , MEGA(null)
        , NA(null);

        public final Double high;

        private MarketCapType(Double high) {
            this.high = high;
        }
    }
}
