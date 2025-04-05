public class CreditCardPayment extends Payment {
    public CreditCardPayment(double amount, String currency,
                             Map<String, String> customerInfo,
                             Map<String, String> paymentDetails) {
        super(amount, currency, customerInfo, paymentDetails);
    }

    @Override
    public boolean validatePayment() {
        return amount > 0 &&
                (currency.equals("USD") || currency.equals("EUR") || currency.equals("GBP")) &&
                customerInfo.containsKey("email") &&
                paymentDetails.getOrDefault("card_number", "").length() >= 12;
    }

    @Override
    public Map<String, String> processPayment() {
        String transactionId = "CC" + new Date().getTime();
        System.out.println("Processing credit card payment for " + customerInfo.get("name"));
        return Map.of("status", "success", "transaction_id", transactionId);
    }
}
