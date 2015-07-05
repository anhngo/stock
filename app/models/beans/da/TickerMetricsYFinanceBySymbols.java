package models.beans.da;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anhngo on 6/18/15.
 */
public class TickerMetricsYFinanceBySymbols {

    public final Map<String, TickerMetricsYFinance> tickersMap;

    private TickerMetricsYFinanceBySymbols(Map<String, TickerMetricsYFinance> tickersMap) {
        if (tickersMap != null) {
            this.tickersMap = tickersMap;
        } else {
            this.tickersMap = new HashMap<>();
        }
    }

    public static TickerMetricsYFinanceBySymbols build() {
        return new TickerMetricsYFinanceBySymbols(null);
    }

    public static TickerMetricsYFinanceBySymbols build(JSONArray jsonArray) {
        if (jsonArray == null) {
            return build();
        } else {
            Map<String, TickerMetricsYFinance> tickersMapBuilder = new HashMap<>();
            try {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject json = jsonArray.getJSONObject(i);
                    TickerMetricsYFinance tickerMetricsYFinance = TickerMetricsYFinance.build(json);
                    tickersMapBuilder.put(tickerMetricsYFinance.symbol, tickerMetricsYFinance);
                }
            } catch (JSONException e) {
                // TODO: log msg for json parsing errors
            }
            return new TickerMetricsYFinanceBySymbols(tickersMapBuilder);
        }
    }
}
