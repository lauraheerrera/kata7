package software.ulpgc.kata7.io.currency;

import com.google.gson.Gson;
import software.ulpgc.kata7.io.Deserializer;

public class FixerCurrencyDeserializer implements Deserializer {
    @Override
    public Object deserialize(String json) {
        return new Gson().fromJson(json, CurrencyResponse.class);
    }
}
