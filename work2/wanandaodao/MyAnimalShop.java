package com.wanandaodao.zoo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

/**
 * @author 晚安叨叨
 */
public class MyAnimalShop implements AnimalShop {
    private double balance;
    private ArrayList<Animal>animalList;
    private ArrayList<Customer>customerList;
    private boolean isOpen;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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

    public MyAnimalShop(double balance, ArrayList<Animal> animalList, ArrayList<Customer> customerList, boolean isOpen) {
        this.balance = balance;
        this.animalList = animalList;
        this.customerList = customerList;
        this.isOpen = isOpen;
    }

    @Override
    public void buyNewAnimal(Animal animal) {
        if(balance-animal.price<0){
            throw new InsufficientBalanceException(balance);
        }else{
            balance-=animal.price;
            animalList.add(animal);
        }
    }

    @Override
    public void treatCustomer(Customer cus) {
        //找不到需要购买的动物
        if(!animalList.contains(cus.getAnimal())){
            throw new AnimalNotFountException(cus.getAnimal());
        }else{
            if(customerList.contains(cus)){
                customerList.remove(cus);
            }
            //更新顾客到店信息
            cus.setLatestTime(LocalDate.now());
            cus.autoincrement();
            customerList.add(cus);
            animalList.remove(cus.getAnimal());
            balance+=cus.getAnimal().price;
            System.out.println(cus.getName()+"已成功购买"+cus.getAnimal().toString());
        }
    }

    @Override
    public void goOutOfBusiness() {
        double ans=0;
        LocalDate date=LocalDate.now();
        System.out.println("当天所有接待过的顾客为: ");
        for (Customer cus : customerList) {
            if (date.equals(cus.getLatestTime())) {
                System.out.println(cus.toString());
                ans += cus.getAnimal().price;
            }
        }
        System.out.println("当天的利润为: "+ans);
    }
}
