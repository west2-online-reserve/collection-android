package com.example.animalshop;

import java.util.ArrayList;
import java.util.List;


public class MyAnimalShop implements AnimalShop {
    private double balance;
    private List<Animal> animalList;
    private List<Customer> customerList;
    private boolean isInBusiness;
    private double dailyProfit;
    private List<Customer> todayCustomers;

    public MyAnimalShop(double initialBalance) {
        this.balance = initialBalance;
        this.animalList = new ArrayList<>();
        this.customerList = new ArrayList<>();
        this.todayCustomers = new ArrayList<>();
        this.isInBusiness = true;
        this.dailyProfit = 0.0;
    }



    /**
     * 买入动物
     */
    @Override
    public void purchaseAnimal(Animal animal) {
        if (!isInBusiness) {
            throw new RuntimeException("店铺已歇业，无法买入动物");
        }

        if (animal.getPrice() > balance) {
            throw new InsufficientBalanceException(
                    "余额不足！" );
        }

        balance -= animal.getPrice();
        animalList.add(animal);
        dailyProfit -= animal.getPrice(); // 记录成本支出

        System.out.println("成功买入: " + animal);
    }

    /**
     * 招待客户
     */
    @Override
    public void serveCustomer(Customer customer) {
        if (!isInBusiness) {
            throw new RuntimeException("店铺已歇业，无法招待客户");
        }

        if (animalList.isEmpty()) {
            throw new AnimalNotFoundException("店内没有动物可出售！");
        }
        // 更新客户信息
        if (customerList.contains(customer)) {
            // 老客户
            Customer existingCustomer = customerList.get(customerList.indexOf(customer));
            existingCustomer.setVisitCount(existingCustomer.getVisitCount() + 1);
            existingCustomer.setLatestVisitDate(java.time.LocalDate.now());
        } else {
            // 新客户
            customerList.add(customer);
        }

        // 记录今日客户
        if (!todayCustomers.contains(customer)) {
            todayCustomers.add(customer);
        }
        // 出售第一只动物
        Animal animalToSell = animalList.get(0);
        // 完成交易
        balance += animalToSell.getPrice();
        dailyProfit += animalToSell.getPrice(); // 记录收入
        animalList.remove(0);

        System.out.println("出售动物: " + animalToSell);
        System.out.println("客户信息: " + customer);
    }

    /**
     * 歇业
     */
    @Override
    public void closeBusiness() {
        isInBusiness = false;

        System.out.println("\n=== 今日营业报告 ===");
        System.out.println("今日利润: " + dailyProfit + "元");
        System.out.println("今日客户数量: " + todayCustomers.size() + "位");

        if (!todayCustomers.isEmpty()) {
            System.out.println("\n今日光顾的客户列表:");
            todayCustomers.forEach(System.out::println);
        }

        // 重置今日数据
        todayCustomers.clear();
        dailyProfit = 0.0;
        isInBusiness = true; // 第二天重新开业
    }

    // Get方法
    public double getBalance() {
        return this.balance;
    }

    public List<Animal> getAnimalList() {return new ArrayList<>(animalList);}

    public List<Customer> getCustomerList() {
        return new ArrayList<>(customerList);
    }

    public boolean isInBusiness() {
        return isInBusiness;
    }

    public double getDailyProfit() {
        return dailyProfit;
    }
}