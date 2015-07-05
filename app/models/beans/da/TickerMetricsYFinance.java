package models.beans.da;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by anhngo on 6/17/15.
 */
public class TickerMetricsYFinance {

    public final String symbol;
    public final Double price;
    public final Double change;
    public final Double changePrcnt;
    public final Double marketCap;

    private TickerMetricsYFinance(String symbol, Double price, Double change, Double changePrcnt, Double marketCap) {
        this.symbol = symbol;
        this.price = price;
        this.change = change;
        this.changePrcnt = changePrcnt;
        this.marketCap = marketCap;
    }

    public static TickerMetricsYFinance build() {
        return new TickerMetricsYFinance(null, null, null, null, null);
    }

    public static TickerMetricsYFinance build(JSONObject json) {
        if (json == null) {
            return build();
        } else {
            try {
                return new TickerMetricsYFinance(
                        json.getString("symbol")
                        , json.getDouble("price")
                        , json.getDouble("change")
                        , json.getDouble("chg_percent")
                        , json.getDouble("market_cap")
                );
            } catch (JSONException e) {
                // TODO: log msg for json parsing errors
                return build();
            }
        }
    }
}
