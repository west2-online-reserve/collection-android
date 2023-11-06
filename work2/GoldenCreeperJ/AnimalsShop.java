package GoldenCreeperJ;
/**
 * @author GoldenCreeperJ
 * @date 2023/11/7
 */
public interface AnimalsShop {
    void buynewanimals(Animal animal);

    void treatcustomers(Customer customer, Animal animal) throws AnimalNotFountException;

    void closebusiness();
}
