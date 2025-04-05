public abstract class Payment {
    protected double amount;
    protected String currency;
    protected Map<String, String> customerInfo;
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
/**
 * Abstract base class for all payment types.
 * Defines structure and validation + processing contract.
 */
