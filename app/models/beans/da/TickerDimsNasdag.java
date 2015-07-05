package models.beans.da;

import com.google.common.base.Strings;
import controllers.libs.Constant;
import controllers.libs.Utils;

/**
 * Created by anhngo on 6/17/15.
 */
public class TickerDimsNasdag {

    public final String symbol;
    public final String name;
    public final Constant.MarketCapType marketCapType;
    public final Integer ipoYear;
    public final String sector;
    public final String industry;

    private TickerDimsNasdag(
            String symbol
            , String name
            , Constant.MarketCapType marketCapType
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

    public static TickerDimsNasdag build() {
        return new TickerDimsNasdag(null, null, null, null, null, null);
    }

    public static TickerDimsNasdag build(String cvsRow) {
        if (Strings.isNullOrEmpty(cvsRow)) {
            return build();
        } else {
            String row = cvsRow.substring(1, cvsRow.length() - 3);
            String[] items = row.split("\",\"");
            if (items.length == 8) {
                return new TickerDimsNasdag (
                                items[0]
                                , items[1]
                                , Utils.parseMarketCapTypeFromNasdaq(items[3])
                                , "n/a".equals(items[4]) ? null : new Integer(items[4])
                                , items[5]
                                , items[6]
                        );
            } else {
                return build();
            }
        }
    }
}
