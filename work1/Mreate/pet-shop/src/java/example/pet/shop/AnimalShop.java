package example.pet.shop;

import example.pet.animal.Animal;
import example.pet.customer.Customer;

public interface AnimalShop {

    void buyAnimal(Animal animal);

    void acceptCustomer(Customer customer);

    void sellAnimal(Customer customer, Animal animal);

    void close();

    boolean isOpen();

}
