package work2.PrinceSaoKe;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MyAnimalShop implements AnimalShop {

    private double balance; // 余额
    private double preBalance; // 每天刚开张时的余额
    private List<Animal> animals = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private boolean isOpen = true;
    private LocalDate date; // 宠物店当前的日期

    public boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public LocalDate getDate() {
        return date;
    }

    /**
     * 构造函数
     * 
     * @param balance 刚开业时的余额
     * @param date    开业日期
     */
    public MyAnimalShop(double balance, LocalDate date) {
        this.balance = balance;
        preBalance = balance;
        this.date = date;
    }

    /**
     * 宠物进货
     * 
     * @param animal 进货的宠物
     * @param price  进价
     */
    @Override
    public void buyNewAnimal(Animal animal, double price) {
        if (!isOpen) {
            System.out.println("宠物店未开张！");
            return;
        }

        try {
            if (balance < price) {
                throw new InsufficientBalanceException();
            } else {
                animals.add(animal);
                balance -= price;
                System.out.println("已购买" + animal.toString() + "，花费" + price + "元");
            }
        } catch (InsufficientBalanceException e) {
            e.print().printStackTrace();
        }
    }

    /**
     * 招待顾客
     * 
     * @param customer 光顾的客人
     * @param animal   客人购买的宠物
     */
    @Override
    public void entertainCustomer(Customer customer, Animal animal) {
        if (!isOpen) {
            System.out.println("宠物店未开张！");
            return;
        }

        if (customer.getVisitCount() == 0)
            customers.add(customer);
        customer.setVisitCount(customer.getVisitCount() + 1);
        customer.setLastestVisitDate(date);

        try {
            if (animals.contains(animal)) {
                System.out.print("售出动物：");
                System.out.println(animal.toString());
                balance += animal.price;
                animals.remove(animal);
            } else {
                throw new AnimalNotFoundException();
            }
        } catch (AnimalNotFoundException e) {
            e.print().printStackTrace();
        }
    }

    /**
     * 宠物店打烊。
     * 输出今日光顾的客户，计算今日净利润，日期+1
     */
    @Override
    public void closeShop() {
        if (isOpen) {
            isOpen = false;
        } else {
            System.out.println("宠物店还未开张，无法关闭！");
        }

        System.out.println(date.toString() + "光顾的客户：");
        for (Customer customer : customers) {
            if (customer.getLastestVisitDate().isEqual(date)) {
                System.out.println(customer.toString());
            }
        }

        System.out.println("今日利润：" + (balance - preBalance));
        preBalance = balance;

        date = date.plusDays(1);
    }

    @Override
    public void openShop() {
        if (isOpen) {
            System.out.println("宠物店还未关闭，无法开张！");
        } else {
            isOpen = true;
        }
    }

}
