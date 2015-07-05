package models.requests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anhngo on 6/17/15.
 */
public class TickersDARequest {
    public final List<String> symbols;

    public TickersDARequest(
            TickersServiceRequest serviceRequest
    ) {
        if (serviceRequest != null) {
            symbols = serviceRequest.symbols;
        } else {
            symbols = new ArrayList<>();
        }
    }
}
