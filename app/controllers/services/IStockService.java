package controllers.services;

import controllers.beans.Quote;
import controllers.requests.QuoteRequest;
import play.libs.F;

/**
 * Created by anhngo on 4/29/15.
 */
public interface IStockService {
    public F.Promise<Quote> getQuote(final QuoteRequest request);
}
