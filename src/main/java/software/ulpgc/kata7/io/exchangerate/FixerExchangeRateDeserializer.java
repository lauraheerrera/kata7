package software.ulpgc.kata7.io.exchangerate;

import com.google.gson.Gson;
import software.ulpgc.kata7.io.Deserializer;

public class FixerExchangeRateDeserializer implements Deserializer {
    @Override
    public Object deserialize(String json) {
        return new Gson().fromJson(json, ExchangeRateResponse.class);
    }
}
