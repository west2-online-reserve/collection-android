package example.pet;

import example.pet.animal.Animal;
import example.pet.animal.impl.Cat;
import example.pet.animal.impl.Dog;
import example.pet.customer.Customer;
import example.pet.shop.AnimalShop;
import example.pet.shop.impl.MyAnimalShop;

public final class Test {

    public static void main(String[] args) {
        AnimalShop shop = new MyAnimalShop(1000D);
        Cat catMeow = new Cat("Meow", 3, Animal.Gender.FEMALE);
        shop.buyAnimal(catMeow);
        shop.buyAnimal(new Dog("123", 5, Animal.Gender.MALE));
        Customer customerA = new Customer("John", 30);
        Customer customerB = new Customer("Jonny", 31);
        shop.acceptCustomer(customerA);
        shop.acceptCustomer(customerB);
        shop.sellAnimal(customerB, catMeow);
        shop.close();
    }

}
