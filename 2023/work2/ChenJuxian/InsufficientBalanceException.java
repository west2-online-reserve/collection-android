public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(String message) { //自定义异常
        super(message);
    }

}
