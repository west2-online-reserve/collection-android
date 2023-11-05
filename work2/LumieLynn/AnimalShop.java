import java.io.IOException;

public interface AnimalShop {
    public void addInitialAnimal(Animal animal);

    public void buyNewAnimal(Animal animal);

    public void entertainCustomer(Customer customer, Animal animal) throws IOException;

    public void closeShop();

    public void openShop();
}
