package AnimalShop;

import java.time.LocalDate;
import java.util.LinkedList;
/**
 * @version 1.2 2023.11.6
 * @author feixiangdeyumao
 *
 * MyAnimalShop 是一个实现了 MAnimalShop 接口的具体类。
 */
public class MyAnimalShop implements AnimalShop{
    private double balance;
    private double profit;
    private boolean whetherClosed;
    LinkedList<Animal> animalList;
    LinkedList<Customer> customerList;

    public MyAnimalShop() {
        this.balance = 1000.0;
        this.profit = 0.0;
        this.whetherClosed = false;
        this.animalList = new LinkedList<>();
        this.customerList = new LinkedList<>();
    }

    public MyAnimalShop(double balance, double profit, boolean isClosed, LinkedList<Animal> animalList, LinkedList<Customer> customerList) {
        this.balance = balance;
        this.profit = profit;
        this.whetherClosed = isClosed;
        this.animalList =  animalList;
        this.customerList = customerList;
    }

    @Override
    public void buyNewAnimal(Animal animalToBuy) throws InsufficientBalanceException{
        if(balance > animalToBuy.cost){
            balance -= animalToBuy.cost; // 减去买宠物的成本价
            animalList.add(animalToBuy); // 把买来的宠物加入链表
            System.out.println("Success to buy animal :" + animalToBuy.getAnimalName() + ", the rest balance is: " + balance);
        }
        else { //钱不够进货新宠物
            throw new InsufficientBalanceException(balance, animalToBuy);
        }
    }

    @Override
    public void assistCustomer(Customer customer, Animal animalToSell) throws AnimalNotFountException{
        if(whetherClosed){ // 店关了
            System.out.println("The shop is closed, please come another day");
        }
        //店开着
        else{
            // 检查是否来了不止一次，是的话只有第一次会被加入链表
            if(!customerList.contains(customer)){
                customerList.add(customer); // 加入顾客名单
            }

            customer.addTimesOfVisits(); // 增加到店次数
            customer.updateLastVisitTime(LocalDate.now()); //更新最新到店时间

            if(animalList.contains(animalToSell)){ // 如果店里能找到这个宠物
                System.out.println(customer.getCustomerName() + " bought an animal called " + animalToSell.getAnimalName());
                profit += animalToSell.price; // 赚了该宠物售价，加到利润上
                animalList.remove(animalToSell); // 把卖掉的宠物移出名单
            }
            else{ // 店里没有这个宠物
                throw new AnimalNotFountException(animalToSell.getAnimalName());
            }
        }
    }

    @Override
    public void closeShop() {
        // 关店
        whetherClosed = true;
        System.out.println("Close the shop");
        // 计算并打印利润和余额
        balance += profit;
        System.out.println("Today's profit: " + profit);
        profit = 0; // 清空当天利润
        //列出今日光顾的顾客
        System.out.println("Today's customer: ");
        for(Customer customer : customerList){
            if(customer.getLastVisitTime().equals(LocalDate.now())){
                System.out.println(customer.getCustomerName() + ", times of visit: " + customer.getTimesOfVisits());
            }
        }
    }

    public void openShop(){
        whetherClosed = false;
        System.out.println("Open the shop");
    }

    public boolean getIsClosed(){
        return whetherClosed;
    }

    public void setIsClosed(boolean isClosed){
        this.whetherClosed = isClosed;
    }
}
