package work2.PrinceSaoKe;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException print() {
        System.out.println("余额不足！");
        return this;
    }

}
