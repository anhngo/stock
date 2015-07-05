package models.requests;

import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by anhngo on 6/17/15.
 */
public class TickersServiceRequest {
    public final List<String> symbols;

    public TickersServiceRequest(
            String symbols
    ) {
        if (!Strings.isNullOrEmpty(symbols)) {
            String[] symbolsArray = symbols.split(",");
            this.symbols = Arrays.asList(symbolsArray);
        } else {
            this.symbols = new ArrayList<>();
        }
    }
}
