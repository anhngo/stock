package controllers.services;

import controllers.beans.TickerDim;
import controllers.beans.TickerFact;
import controllers.requests.TickerRequest;
import play.libs.F;

import java.util.List;

/**
 * Created by anhngo on 4/29/15.
 */
public interface ITickerService {
    public F.Promise<List<TickerDim>> getTickersList(final TickerRequest request);
    public F.Promise<TickerFact> getTicker(final TickerRequest request);
}
