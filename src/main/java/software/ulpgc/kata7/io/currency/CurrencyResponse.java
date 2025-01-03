package software.ulpgc.kata7.io.currency;


import java.util.Map;

public record CurrencyResponse(boolean success, Map<String, String> symbols) {
}
