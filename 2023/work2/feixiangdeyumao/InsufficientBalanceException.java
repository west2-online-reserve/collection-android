package AnimalShop;

/**
 * @version 1.0 2023.10.31
 * @author feixiangdeyumao
 */
public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(double balance, Animal animal){
        super("Insufficient balance!, balance: " + balance + ", cost of the animal: " + animal.cost);
    }
}
