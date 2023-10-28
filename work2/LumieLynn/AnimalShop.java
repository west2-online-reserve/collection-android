import java.io.IOException;

public interface AnimalShop {
    public void setInitialAnimal(Animal animal);

    public void buyNewAnimals(Animal animal);

    public void entertainCustomer(Customer customer, Animal animal) throws IOException;

    public void closeShop();

    public void openShop();
}
