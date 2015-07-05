package models.beans.da;

import com.google.common.base.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anhngo on 6/18/15.
 */
public class TickerDimsNasdagBySymbols {

    public final Map<String, TickerDimsNasdag> tickersMap;

    private TickerDimsNasdagBySymbols(Map<String, TickerDimsNasdag> tickersMap) {
        if (tickersMap != null) {
            this.tickersMap = tickersMap;
        } else {
            this.tickersMap = new HashMap<>();
        }
    }

    public static TickerDimsNasdagBySymbols build() {
        return new TickerDimsNasdagBySymbols(null);
    }

    public static TickerDimsNasdagBySymbols build(String cvsRows) {
        if (Strings.isNullOrEmpty(cvsRows)) {
            return build();
        } else {
            Map<String, TickerDimsNasdag> tickersMapBuilder = new HashMap<>();
            boolean isHeaderRow = true;
            for (String row : cvsRows.split("\n")) {
                // skip the header line
                if (isHeaderRow) {
                    isHeaderRow = false;
                    continue;
                }

                TickerDimsNasdag tickerDimsNasdag = TickerDimsNasdag.build(row);
                tickersMapBuilder.put(tickerDimsNasdag.symbol, tickerDimsNasdag);
            }
            return new TickerDimsNasdagBySymbols(tickersMapBuilder);
        }
    }
}
