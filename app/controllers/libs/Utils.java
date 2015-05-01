package controllers.libs;

/**
 * Created by anhngo on 4/30/15.
 */
public class Utils {
    public static Constant.MarketCapType parseMarketCapTypeFromNasdaq(String text) {
        if (text == null || "n/a".equals(text) || !text.startsWith("$")) {
            return Constant.MarketCapType.NA;
        }
        if (!text.endsWith("M") && !text.endsWith("B")) {
            return Constant.MarketCapType.NANO;
        }

        // extract market cap value in M
        double marketCapValue = new Double(text.substring(1, text.length()-1));
        if (text.endsWith("B")) {
            marketCapValue = marketCapValue * 1000.0;
        }

        // get market cap type
        if (marketCapValue <= Constant.MarketCapType.NANO.high) return Constant.MarketCapType.NANO;
        if (marketCapValue <= Constant.MarketCapType.MICRO.high) return Constant.MarketCapType.MICRO;
        if (marketCapValue <= Constant.MarketCapType.SMALL.high) return Constant.MarketCapType.SMALL;
        if (marketCapValue <= Constant.MarketCapType.MID.high) return Constant.MarketCapType.MID;
        if (marketCapValue <= Constant.MarketCapType.LARGE.high) return Constant.MarketCapType.LARGE;
        return Constant.MarketCapType.MEGA;
    }
}
