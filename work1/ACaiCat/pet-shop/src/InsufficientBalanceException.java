public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(double balance, double price) {
        super(String.format("Animal need $%.2f, but shop only has remaining $%.2f", price, balance));
    }
}
