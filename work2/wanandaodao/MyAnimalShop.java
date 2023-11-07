package com.wanandaodao.zoo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author 晚安叨叨
 */
public class MyAnimalShop implements AnimalShop {
    private double openBalance;
    private double closeBalance;
    private ArrayList<Animal> animalList;
    private ArrayList<Customer> customerList;
    private boolean isOpen;

    public MyAnimalShop(double closeBalance, double openBalance, ArrayList<Animal> animalList, ArrayList<Customer> customerList, boolean isOpen) {
        this.closeBalance = closeBalance;
        this.openBalance = openBalance;
        this.animalList = animalList;
        this.customerList = customerList;
        this.isOpen = isOpen;
    }

    public double getOpenBalance() {
        return openBalance;
    }

    public void setOpenBalance(double openBalance) {
        this.openBalance = openBalance;
    }

    public double getCloseBalance() {
        return closeBalance;
    }

    public void setCloseBalance(double closeBalance) {
        this.closeBalance = closeBalance;
    }

    public ArrayList<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(ArrayList<Animal> animalList) {
        this.animalList = animalList;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public void buyNewAnimal(Animal animal) {
        if (closeBalance - animal.price < 0) {
            throw new InsufficientBalanceException(closeBalance);
        } else {
            closeBalance -= animal.price;
            animalList.add(animal);
        }
    }

    @Override
    public void treatCustomer(Customer cus, Animal animal) {
        //找不到需要购买的动物
        if (!animalList.contains(animal)) {
            throw new AnimalNotFountException(animal);
        } else {
            if (customerList.contains(cus)) {
                customerList.remove(cus);
            }
            //更新顾客到店信息
            cus.setLatestTime(LocalDate.now());
            cus.autoincrement();
            customerList.add(cus);
            animalList.remove(animal);
            closeBalance += animal.price;
            System.out.println(cus.getName() + "已成功购买" + animal.toString());
        }
    }

    @Override
    public void goOutOfBusiness() {
        LocalDate date = LocalDate.now();
        System.out.println("当天所有接待过的顾客为: ");
        for (Customer cus : customerList) {
            if (date.equals(cus.getLatestTime())) {
                System.out.println(cus.toString());
            }
        }
        System.out.println("当天的利润为: " + (closeBalance - openBalance));
    }
}
