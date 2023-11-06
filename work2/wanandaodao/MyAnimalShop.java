package com.wanandaodao.zoo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class MyAnimalShop implements AnimalShop {
    private double balance;
    public ArrayList<Animal>animalList;
    public ArrayList<Customer>customerList;
    public boolean isOpen;

    public double getBalance() {
        return balance;
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
        customerList.add(cus);
        //找不到需要购买的动物
        if(!animalList.contains(cus.animal)){
            throw new AnimalNotFountException(cus.animal);
        }else{
            animalList.remove(cus.animal);
            balance+=cus.animal.price;
            System.out.println("您已成功购买:"+cus.animal.toString());
        }
    }

    @Override
    public void goOutOfBusiness() {
        double ans=0;
        LocalDate date=LocalDate.now();
        for (Customer cus : customerList) {
            if (date.equals(cus.latestTime)) {
                System.out.println(cus.toString());
                ans += cus.animal.price;
            }
        }
        System.out.println("当天的利润为: "+ans);
    }
}
