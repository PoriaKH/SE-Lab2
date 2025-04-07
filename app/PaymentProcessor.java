package app;

import core.Payment;
import gateway.PaymentGateway;

import java.util.Date;
import java.util.Map;

public class PaymentProcessor {
    private final PaymentGateway gateway;

    public PaymentProcessor(PaymentGateway gateway) {
        this.gateway = gateway;
    }

    public Map<String, String> process(Payment payment) {
        if (!payment.validatePayment()) {
            return Map.of("status", "failed", "message", "Validation error");
        }

        Map<String, String> result = gateway.processPayment(payment);
        logTransaction(payment, result);
        return result;
    }

    private void logTransaction(Payment payment, Map<String, String> result) {
        String logEntry = String.format("%s - %s payment of %.2f %s for %s: %s",
                new Date(),
                payment.getClass().getSimpleName(),
                payment.amount,
                payment.currency,
                payment.customerInfo.get("name"),
                result);
        System.out.println("LOG: " + logEntry);
    }
}
