package software.ulpgc.kata7.io.exchangerate;

import software.ulpgc.kata7.io.FixerAPIReader;
import software.ulpgc.kata7.model.Currency;
import software.ulpgc.kata7.model.ExchangeRate;

public class ExchangeRateLoader {
    private final FixerExchangeRateAdapter adapter;
    private final FixerExchangeRateDeserializer deserializer;
    private final FixerAPIReader reader;

    public ExchangeRateLoader(FixerExchangeRateAdapter adapter, FixerExchangeRateDeserializer deserializer, FixerAPIReader reader) {
        this.adapter = adapter;
        this.deserializer = deserializer;
        this.reader = reader;
    }


    public ExchangeRate load(Currency from, Currency to) {
        return adapter.adapt(deserializer.deserialize(reader.read()), from, to);
    }
}
