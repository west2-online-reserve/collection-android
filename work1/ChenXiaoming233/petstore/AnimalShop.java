package petstore;

// 宠物店基础功能

public interface AnimalShop {
    void buyAnimal(Animal animal);
    void serveCustomer(Customer customer);
    void closeShop();
}
