package core;

import java.util.Map;

public abstract class Payment {
    public double amount;
    public String currency;
    public Map<String, String> customerInfo;
    protected Map<String, String> paymentDetails;

    public Payment(double amount, String currency,
                   Map<String, String> customerInfo,
                   Map<String, String> paymentDetails) {
        this.amount = amount;
        this.currency = currency;
        this.customerInfo = customerInfo;
        this.paymentDetails = paymentDetails;
    }

    public abstract boolean validatePayment();
    public abstract Map<String, String> processPayment();
}
