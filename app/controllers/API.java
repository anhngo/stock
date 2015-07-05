package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import controllers.services.TickerService;
import models.beans.service.TickersList;
import models.renderers.TickersListRenderer;
import models.requests.TickersServiceRequest;
import org.json.JSONObject;
import play.libs.F;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import scala.Option;

/**
 * Created by anhngo on 5/27/15.
 */
public class API extends Controller {

    private static TickerService tickerService = new TickerService();

    @BodyParser.Of(BodyParser.Json.class)
    public static Result getTickersDims(String cvsSymbols) {
        ObjectNode result = Json.newObject();
        return tickerService
                .getTickersDimList(new TickersServiceRequest(cvsSymbols))
                .<Result>map(
                        new F.Function<TickersList, Result>() {
                            @Override
                            public Result apply(TickersList tickersList) throws Throwable {
                                if (tickersList != null) {
                                    result.put("status", "OK");
                                    JSONObject dataBuilder = new JSONObject();
                                    TickersListRenderer.toJson(dataBuilder, Option.apply(tickersList));
                                    JsonNode data = Json.parse(dataBuilder.toString());
                                    result.put("data", data);
                                    return ok(result);
                                } else {
                                    result.put("status", "KO");
                                    result.put("message", "getTickersDims failed!");
                                    return internalServerError(result);
                                }
                            }
                        }
                )
                .get(10000)
                ;
    }
}
