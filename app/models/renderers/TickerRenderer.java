package models.renderers;

import controllers.libs.Utils;
import models.beans.service.Ticker;
import org.json.JSONException;
import org.json.JSONObject;
import scala.Option;

/**
 * Created by anhngo on 6/17/15.
 */
public class TickerRenderer {
    public static void toJson(JSONObject json, Option<Ticker> data) throws JSONException {
        if (json == null) {
            return;
        }

        String symbol = null;
        String name = null;
        String marketCapType = null;
        Integer ipoYear = null;
        String sector = null;
        String industry = null;
        Double price = null;
        Double change = null;
        Double changePrcnt = null;
        Double marketCap = null;

        if (data.isDefined()) {
            symbol = data.get().symbol;
            name = data.get().name;
            marketCapType = data.get().marketCapType == null ? null : data.get().marketCapType.name();
            ipoYear = data.get().ipoYear;
            sector = data.get().sector;
            industry = data.get().industry;
            price = data.get().price;
            change = data.get().change;
            changePrcnt = data.get().changePrcnt;
            marketCap = data.get().marketCap;
        }

        json.put("symbol", Utils.getJSONValue(symbol));
        json.put("name", Utils.getJSONValue(name));
        json.put("marketCapType", Utils.getJSONValue(marketCapType));
        json.put("ipoYear", Utils.getJSONValue(ipoYear));
        json.put("sector", Utils.getJSONValue(sector));
        json.put("industry", Utils.getJSONValue(industry));
        json.put("price", Utils.getJSONValue(price));
        json.put("change", Utils.getJSONValue(change));
        json.put("changePercentage", Utils.getJSONValue(changePrcnt));
        json.put("marketCapValue", Utils.getJSONValue(marketCap));
    }
}
