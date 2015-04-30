package controllers.beans;

/**
 * Created by anhngo on 4/29/15.
 */
public class Quote {

    public final String name;
    public final String symbol;

    public final Double change;
    public final Double changePrcnt;
    public final Double price;

    public final Double marketCap;

    public Quote(
            String name
            , String symbol
            , Double change
            , Double changePrcnt
            , Double price
            , Double marketCap
    ) {
        this.name = name;
        this.symbol = symbol;
        this.change = change;
        this.changePrcnt = changePrcnt;
        this.price = price;
        this.marketCap = marketCap;
    }
}
