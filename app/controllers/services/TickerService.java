package controllers.services;

import controllers.das.TickerDimsNasdagBySymbolsDA;
import controllers.das.TickerMetricsYFinanceBySymbolsDA;
import models.beans.da.TickerDimsNasdagBySymbols;
import models.beans.da.TickerMetricsYFinanceBySymbols;
import models.beans.service.TickersList;
import models.requests.TickersDARequest;
import models.requests.TickersServiceRequest;
import play.libs.F;

/**
 * Created by anhngo on 7/4/15.
 */
public class TickerService {
    TickerDimsNasdagBySymbolsDA tickerDimsNasdagBySymbolsDA = new TickerDimsNasdagBySymbolsDA();
    TickerMetricsYFinanceBySymbolsDA tickerMetricsYFinanceBySymbolsDA = new TickerMetricsYFinanceBySymbolsDA();

    public F.Promise<TickersList> getTickersDimList(final TickersServiceRequest request) {
        return tickerDimsNasdagBySymbolsDA.getResult()
                .<TickersList>map (
                        new F.Function<TickerDimsNasdagBySymbols, TickersList>() {
                            @Override
                            public TickersList apply(TickerDimsNasdagBySymbols tickerDimsNasdagBySymbols) throws Throwable {
                                if (tickerDimsNasdagBySymbols != null) {
                                    return new TickersList(tickerDimsNasdagBySymbols, null);
                                }
                                return new TickersList(null, null);
                            }
                        }
                );
    }

    public F.Promise<TickersList> getTickersMetricsList(final TickersServiceRequest request) {
        return tickerMetricsYFinanceBySymbolsDA.getResult(new TickersDARequest(request))
                .<TickersList>map (
                        new F.Function<TickerMetricsYFinanceBySymbols, TickersList>() {
                            @Override
                            public TickersList apply(TickerMetricsYFinanceBySymbols tickerMetricsYFinanceBySymbols) throws Throwable {
                                if (tickerMetricsYFinanceBySymbols != null) {
                                    return new TickersList(null, tickerMetricsYFinanceBySymbols);
                                }
                                return new TickersList(null, null);
                            }
                        }
                );
    }
}
