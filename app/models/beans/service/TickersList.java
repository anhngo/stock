package models.beans.service;

import models.beans.da.TickerDimsNasdag;
import models.beans.da.TickerDimsNasdagBySymbols;
import models.beans.da.TickerMetricsYFinance;
import models.beans.da.TickerMetricsYFinanceBySymbols;

import java.util.*;

/**
 * Created by anhngo on 6/17/15.
 */
public class TickersList {
    public final List<Ticker> tickersList;

    public TickersList(TickerDimsNasdagBySymbols dimsMap, TickerMetricsYFinanceBySymbols metricsMap) {
        dimsMap = dimsMap != null ? dimsMap : TickerDimsNasdagBySymbols.build();
        metricsMap = metricsMap != null ? metricsMap : TickerMetricsYFinanceBySymbols.build();

        Map<String, TickerDimsNasdag> dimsBySymbols = dimsMap.tickersMap;
        Map<String, TickerMetricsYFinance> metricsBySymbols = metricsMap.tickersMap;

        Set<String> symbolsSet = dimsBySymbols.keySet();
        symbolsSet.addAll(metricsBySymbols.keySet());

        List<Ticker> tickerList = new LinkedList<>();
        for (String symbol : symbolsSet) {
            tickerList.add(new Ticker(dimsBySymbols.get(symbol), metricsBySymbols.get(symbol)));
        }
        this.tickersList = tickerList;
    }
}
