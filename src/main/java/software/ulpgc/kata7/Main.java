package software.ulpgc.kata7;

import software.ulpgc.kata7.control.CalculateCommand;
import software.ulpgc.kata7.control.Command;
import software.ulpgc.kata7.control.SwapCommand;
import software.ulpgc.kata7.io.FixerAPI;
import software.ulpgc.kata7.io.FixerAPIReader;
import software.ulpgc.kata7.io.currency.CurrencyLoader;
import software.ulpgc.kata7.io.currency.FixerCurrencyAdapter;
import software.ulpgc.kata7.io.currency.FixerCurrencyDeserializer;
import software.ulpgc.kata7.io.exchangerate.ExchangeRateLoader;
import software.ulpgc.kata7.io.exchangerate.FixerExchangeRateAdapter;
import software.ulpgc.kata7.io.exchangerate.FixerExchangeRateDeserializer;
import software.ulpgc.kata7.model.Currency;
import software.ulpgc.kata7.view.SwingCurrencyDialog;
import software.ulpgc.kata7.view.SwingMoneyDialog;

import java.util.List;

public class Main {
    public static void main(String[] args)  {
        MainFrame mainFrame = new MainFrame();
        List<Currency> currencies = new CurrencyLoader(
                new FixerCurrencyAdapter(),
                new FixerCurrencyDeserializer(),
                new FixerAPIReader(FixerAPI.FIXER_API_CURRENCIES_URL, FixerAPI.FIXER_API_KEY)).get();
        Command calculateCommand = new CalculateCommand(
                mainFrame.moneyDialog().define(currencies),
                mainFrame.currencyDialog().define(currencies),
                new ExchangeRateLoader(
                        new FixerExchangeRateAdapter(),
                        new FixerExchangeRateDeserializer(),
                        new FixerAPIReader(FixerAPI.FIXER_API_EXCHANGE_RATE_URL, FixerAPI.FIXER_API_KEY)
                ),
                mainFrame.moneyDisplay());
        mainFrame.add("Calculate money", calculateCommand);
        Command swapCommand = new SwapCommand(
                ((SwingMoneyDialog) mainFrame.moneyDialog()).getCurrencyDialog(),
                (SwingCurrencyDialog) mainFrame.currencyDialog()
        );
        mainFrame.add("Swap currencies", swapCommand);

        mainFrame.setVisible(true);
    }
}
