package work2.mqyxrmwdxh.animalshop;

/**
 * @author 32867
 */
public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException alarm() {
        System.out.println("余额不足！");
        return this;
    }
}
