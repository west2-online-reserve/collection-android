package GoldenCreeperJ;
/**
 * @author GoldenCreeperJ
 * @date 2023/11/7
 */
public class InsufficientBalanceException extends RuntimeException{

    public InsufficientBalanceException() {
    }

    @Override
    public String toString() {
        return "余额不足!\n";
    }
}
