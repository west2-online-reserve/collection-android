package petstore;

import java.time.LocalDate;
import java.util.ArrayList;

// 宠物店实现类

public class MyAnimalShop implements AnimalShop {
    private double balance;
    private ArrayList<Animal> animals;
    private ArrayList<Customer> customers;
    private boolean open;
    // 简化处理：利润按销售额累计，不单独计算进货成本
    private double todayProfit;

    public MyAnimalShop(double balance) {
        this.balance = balance;
        this.animals = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.open = true;
        this.todayProfit = 0;
    }

    @Override
    public void buyAnimal(Animal animal) {
        if (balance < animal.getPrice()) {
            throw new InsufficientBalanceException("余额不足，无法买入" + animal.getName());
        }
        balance -= animal.getPrice();
        animals.add(animal);
        System.out.println("买入动物：" + animal);
    }

    @Override
    public void serveCustomer(Customer customer) {
        if (animals.isEmpty()) {
            throw new AnimalNotFoundException("店里没有动物了");
        }
        Animal animal = animals.remove(0);
        balance += animal.getPrice();
        todayProfit += animal.getPrice();
        customer.visit(LocalDate.now());
        // 同一个顾客对象只加入一次列表
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println("顾客：" + customer.getName());
        System.out.println("购买动物：" + animal);
    }

    @Override
    public void closeShop() {
        System.out.println("今天的顾客：");
        for (Customer customer : customers) {
            // 只输出最近一次到店日期为今天的顾客
            if (LocalDate.now().equals(customer.getLatestVisitDate())) {
                System.out.println(customer);
            }
        }
        System.out.println("今天利润：" + todayProfit);
        open = false;
    }

    public double getBalance() {
        return balance;
    }
    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public boolean isOpen() {
        return open;
    }
    public double getTodayProfit() {
        return todayProfit;
    }
}
