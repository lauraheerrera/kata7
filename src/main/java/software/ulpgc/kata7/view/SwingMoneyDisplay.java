package software.ulpgc.kata7.view;

import software.ulpgc.kata7.model.Money;

import javax.swing.*;
import java.awt.*;
public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {

    @Override
    public void show(Money money) {
        this.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        this.setText(money.amount() + " " + money.getCurrencyCode());
    }
}
