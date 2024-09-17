package GoldenCreeperJ;
/**
 * @author GoldenCreeperJ
 * @date 2023/11/7
 */
public interface AnimalsShop {
    void buyNewAnimals(Animal animal);

    void treatCustomers(Customer customer, Animal animal) throws AnimalNotFountException;

    void closeBusiness();
}
