package gateway;

import core.Payment;
import java.util.Date;
import java.util.Map;

public class PayPalGateway implements PaymentGateway {
    private String endpoint;

    public PayPalGateway(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public Map<String, String> processPayment(Payment payment) {
        System.out.println("Connecting to PayPal at " + endpoint);
        String id = "PP" + new Date().getTime();
        System.out.println("Processed via PayPal for " + payment.customerInfo.get("name"));
        return Map.of("status", "success", "transaction_id", id);
    }

    @Override
    public Map<String, String> refundPayment(String transactionId) {
        return Map.of("status", "refunded", "transaction_id", transactionId);
    }

    @Override
    public String getTransactionStatus(String transactionId) {
        return "completed";
    }
}
