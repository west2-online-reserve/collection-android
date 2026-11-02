package example.pet.shop.impl;

import example.pet.animal.Animal;
import example.pet.customer.Customer;
import example.pet.exception.AnimalNotFoundException;
import example.pet.exception.InsufficientBalanceException;
import example.pet.exception.ShopClosedException;
import example.pet.shop.AnimalShop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MyAnimalShop implements AnimalShop {

    private double money;
    private double lastDayMoney;
    private final List<Animal> animals;
    private final List<Customer> customers;
    private boolean open;

    public MyAnimalShop(double money) {
        animals = new ArrayList<>();
        customers = new ArrayList<>();
        open = true;
        this.money = money;
        this.lastDayMoney = money;
        logOpen(this);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public void buyAnimal(Animal animal) {
        if (!open) throw new ShopClosedException();
        if (money < animal.getPrice()) {
            throw new InsufficientBalanceException();
        }
        money -= animal.getPrice();
        animals.add(animal);
        logBalance(animal, false);
        logAnimal(animal, true);
    }

    @Override
    public void acceptCustomer(Customer customer) {
        if (!open) throw new ShopClosedException();
        customers.add(customer);
        customer.updateLastJoinShop();
        logCustomer(customer);
    }

    @Override
    public void sellAnimal(Customer customer, Animal animal) {
        if (!open) throw new ShopClosedException();
        if (!animals.contains(animal)) {
            throw new AnimalNotFoundException();
        }
        if (!customers.contains(customer)) {
            acceptCustomer(customer);
        }
        animals.remove(animal);
        money += animal.getPrice();
        logAnimal(animal, false);
        logBalance(animal, true);
    }

    @Override
    public void close() {
        open = false;
        logOpen(this);
        LocalDate today = LocalDate.now();
        System.out.println("----------");
        System.out.println("今日顾客：");
        for (Customer customer : customers) {
            if (customer.getLastJoinShop().equals(today)) {
                System.out.println("- " + customer);
            }
        }
        System.out.println("今日利润：" + (money - lastDayMoney));
        System.out.println("----------");
        lastDayMoney = money;
    }

    @Override
    public boolean isOpen() {
        return open;
    }

    private static void logCustomer(Customer customer) {
        System.out.println("[Customer][+] " + customer.getName());
    }

    private static void logAnimal(Animal animal, boolean isAdd) {
        System.out.println("[Animal][" + (isAdd ? "+" : "-") + "] " + animal.getClass().getSimpleName() + ": " + animal.getName());
    }

    private static void logBalance(Animal animal, boolean isAdd) {
        System.out.println("[Balance][" + (isAdd ? "+" : "-") + "] " + animal.getPrice());
    }

    private static void logOpen(AnimalShop animalShop) {
        System.out.println("[Open] -> " + animalShop.isOpen());
    }

}
