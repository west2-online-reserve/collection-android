import java.time.LocalDate;

public interface AnimalShop {
    void buyAnimal(Animal animal) throws InsufficientBalanceException;
    void serveCustomer(Customer customer);
    void closeShop(LocalDate date);
}
