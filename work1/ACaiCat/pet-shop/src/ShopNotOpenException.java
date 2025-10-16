public class ShopNotOpenException extends RuntimeException {
    public ShopNotOpenException() {
        super("Shop is not open!");
    }
}
