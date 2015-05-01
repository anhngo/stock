package controllers.beans;

/**
 * Created by anhngo on 4/30/15.
 */
public class TickerFact {

    public final Double price;
    public final Double change;
    public final Double changePrcnt;
    public final Double marketCap;

    private TickerFact(Double price, Double change, Double changePrcnt, Double marketCap) {
        this.price = price;
        this.change = change;
        this.changePrcnt = changePrcnt;
        this.marketCap = marketCap;
    }

    public static TickerFact build(Double price, Double change, Double changePrcnt, Double marketCap) {
        return new TickerFact(price, change, changePrcnt, marketCap);
    }

    public static TickerFact build() {
        return new TickerFact(null, null, null, null);
    }
}
