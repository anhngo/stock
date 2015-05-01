package controllers;

import controllers.beans.TickerDim;
import controllers.beans.TickerFact;
import controllers.requests.TickerRequest;
import controllers.services.ITickerService;
import controllers.services.TickerServiceImpl;
import play.libs.F;
import play.mvc.*;

import views.html.*;

import java.util.List;

public class Application extends Controller {

    private static ITickerService tickerService = new TickerServiceImpl();

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static F.Promise<Result> getTicker(String symbol) {
        TickerRequest request = new TickerRequest(symbol);
        return tickerService
                .getTicker(request)
                .map(
                        new F.Function<TickerFact, Result>() {
                            @Override
                            public Result apply(TickerFact tickerResult) throws Throwable {
                                return ok(ticker.render(tickerResult));
                            }
                        }
                );
    }

    public static F.Promise<Result> getTickersList() {
        TickerRequest request = new TickerRequest(null);
        return tickerService
                .getTickersList(request)
                .map(
                        new F.Function<List<TickerDim>, Result>() {
                            @Override
                            public Result apply(List<TickerDim> tickersListResult) throws Throwable {
                                return ok(tickerslist.render(tickersListResult));
                            }
                        }
                );
    }
}
