package app;

import core.*;
import gateway.*;
import config.ConfigManager;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> config = ConfigManager.load("config.properties");

        Payment payment = new CreditCardPayment(
                100,
                "USD",
                Map.of("name", "John Doe", "email", "john@example.com"),
                Map.of("card_number", "123456789012", "expiry", "12/25", "cvv", "123")
        );

        PaymentGateway gateway = new StripeGateway(config.get("stripe_endpoint"));
        PaymentProcessor processor = new PaymentProcessor(gateway);
        Map<String, String> result = processor.process(payment);

        System.out.println("Final Result: " + result);
    }
}
