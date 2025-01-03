package software.ulpgc.kata7.control;

import software.ulpgc.kata7.view.SwingCurrencyDialog;

public class SwapCommand implements Command {
    private final SwingCurrencyDialog fromDialog;
    private final SwingCurrencyDialog toDialog;

    public SwapCommand(SwingCurrencyDialog fromDialog, SwingCurrencyDialog toDialog) {
        this.fromDialog = fromDialog;
        this.toDialog = toDialog;
    }

    @Override
    public void execute() {
        var fromCurrency = fromDialog.get();
        var toCurrency = toDialog.get();

        fromDialog.getCurrencySelector().setSelectedItem(toCurrency);
        toDialog.getCurrencySelector().setSelectedItem(fromCurrency);
    }
}
