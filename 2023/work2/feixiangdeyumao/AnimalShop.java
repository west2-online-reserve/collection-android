package AnimalShop;

/**
 * AnimalShop 是一个接口，定义了三个抽象方法
 * buyNewAnimal 用于买入新动物
 * assistCustomer 用于招待客户
 * closeShop 用于歇业
 */
public interface AnimalShop {
    void buyNewAnimal(Animal animal);
    void assistCustomer(Customer customer, Animal animal);
    void closeShop();
}
