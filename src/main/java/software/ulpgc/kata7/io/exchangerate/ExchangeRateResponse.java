package software.ulpgc.kata7.io.exchangerate;

import java.util.Map;

public record ExchangeRateResponse(boolean success, Map<String, Double> rates){
}
