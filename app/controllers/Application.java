package controllers;

import controllers.beans.Quote;
import controllers.requests.QuoteRequest;
import controllers.services.IStockService;
import controllers.services.StockServiceImpl;
import play.*;
import play.libs.F;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    private static IStockService stockService = new StockServiceImpl();

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static F.Promise<Result> getQuote(String symbol) {
        QuoteRequest request = new QuoteRequest(symbol);
        return stockService
                .getQuote(request)
                .map(
                        new F.Function<Quote, Result>() {
                            @Override
                            public Result apply(Quote quoteResult) throws Throwable {
                                return ok(quote.render(quoteResult));
                            }
                        }
                );
    }
}
