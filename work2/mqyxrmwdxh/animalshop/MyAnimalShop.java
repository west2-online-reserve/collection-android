package work2.mqyxrmwdxh.animalshop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 32867
 */
public class MyAnimalShop implements AnimalShop {
    private String shopName;
    private double openBalance;
    private double closeBalance;
    LocalDate date;
    List<Customer> customersList;
    List<AbstractAnimal> animalList;
    boolean isOpen;

    MyAnimalShop(String shopName, double balance, LocalDate date) {
        this.shopName = shopName;
        openBalance = balance;
        closeBalance = balance;
        this.date = date;
        customersList = new ArrayList<>();
        animalList = new ArrayList<>();
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    @Override
    public boolean openShop() {
        if (isOpen) {
            System.out.println("还未打烊，无需开店！");
            return false;
        } else {
            isOpen = true;
            return true;
        }
    }

    @Override
    public boolean purchaseAnimal(AbstractAnimal animal, double price) {
        if (!isOpen) {
            System.out.println("宠物店未开张！");
            return false;
        }

        try {
            if (price > closeBalance) {
                throw new InsufficientBalanceException();
            } else {
                if (!animalList.contains(animal)) {
                    animalList.add(animal);
                    closeBalance -= price;
                    return true;
                } else {
                    return false;
                }

            }

        } catch (InsufficientBalanceException e) {
            e.alarm().printStackTrace();
            return false;
        }
    }

    @Override
    public void entertainCustomer(Customer customer, AbstractAnimal animal) {
        if (!isOpen) {
            System.out.println("宠物店未开张！");
            return;
        }
        if (!customersList.contains(customer)) {
            customersList.add(customer);
        }

        try {
            customer.setVisitNum(customer.getVisitNum() + 1);
            customer.setLatestTime(date);
            if (animalList.contains(animal)) {
                closeBalance += animal.getPrice();
                customer.addPet(animal);
                System.out.println("顾客" + customer.getName() + "在" + shopName + "购买了" + animal.getName() + "\n" + animal);
                animalList.remove(animal);
            } else {
                throw new AnimalNotFountException();
            }

        } catch (AnimalNotFountException e) {
            e.alarm().printStackTrace();
        }
    }

    @Override
    public void closeShop() {
        if (isOpen) {
            isOpen = false;
            System.out.println("以下是" + date + "日的顾客：");
            for (Customer customer : customersList) {
                if (customer.getLatestTime().equals(date)) {
                    System.out.println(customer);
                }
            }
            double temp = closeBalance - openBalance;
            if (temp > 0) {
                System.out.println("今天收入" + temp + "元," + "余额为" + closeBalance + "元");
            } else {
                System.out.println("今天支出" + -temp + "元," + "余额为" + closeBalance + "元");
            }
            openBalance = closeBalance;
            date = date.plusDays(1);
        } else {
            System.out.println("还未开张，不能歇业！");
        }
    }
}
