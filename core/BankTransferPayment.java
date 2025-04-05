package core;

import java.util.Date;
import java.util.Map;

public class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount, String currency,
                               Map<String, String> customerInfo,
                               Map<String, String> paymentDetails) {
        super(amount, currency, customerInfo, paymentDetails);
    }

    @Override
    public boolean validatePayment() {
        return amount > 0 &&
               (currency.equals("USD") || currency.equals("EUR") || currency.equals("GBP")) &&
               customerInfo.containsKey("email") &&
               paymentDetails.containsKey("account_number");
    }

    @Override
    public Map<String, String> processPayment() {
        String transactionId = "BT" + new Date().getTime();
        System.out.println("Processing bank transfer payment for " + customerInfo.get("name"));
        return Map.of("status", "success", "transaction_id", transactionId);
    }
}
