package work2.hexiaohei;

/**
 * @version 1.0 2023.10.13
 * @author hexiaohei
 */
public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException printClue(){
        System.out.println("余额不足，买不了哦");
        return this;
    }
}
