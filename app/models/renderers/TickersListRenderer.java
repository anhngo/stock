package models.renderers;

import models.beans.service.Ticker;
import models.beans.service.TickersList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import scala.Option;

/**
 * Created by anhngo on 6/17/15.
 */
public class TickersListRenderer {
    public static void toJson(JSONObject json, Option<TickersList> data) throws JSONException {
        JSONArray tickers = new JSONArray();

        if (data.isDefined()) {
            TickersList tickersList = data.get();
            if (tickersList.tickersList != null) {
                for(Ticker ticker : tickersList.tickersList) {
                    JSONObject tickerJson = new JSONObject();
                    TickerRenderer.toJson(tickerJson, Option.apply(ticker));
                    tickers.put(tickerJson);
                }
            }
        }

        json.put("tickers", tickers);
    }
}
