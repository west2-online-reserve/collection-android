/**
 * @Author：realzhenikun
 * @Project：PetShop
 * @Date：2023/11/6
 * @Filename：InsufficientBalanceException
 */
public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String errorMessage) {
        super(errorMessage);
    }
}
