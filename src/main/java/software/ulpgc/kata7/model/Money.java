package software.ulpgc.kata7.model;

public record Money(double amount, Currency currency) {
    public String getCurrencyCode(){ return currency.code();}
}
