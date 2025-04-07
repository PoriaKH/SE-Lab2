package gateway;

import core.Payment;
import java.util.Map;

public interface PaymentGateway {
    Map<String, String> processPayment(Payment payment);
    Map<String, String> refundPayment(String transactionId);
    String getTransactionStatus(String transactionId);
}
