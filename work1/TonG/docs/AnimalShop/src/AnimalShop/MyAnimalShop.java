package AnimalShop;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import java.util.List;


public class MyAnimalShop implements AnimalShop {
    private double Money;
    private List<Animal> Animals;
    private List<Customer> Customers;
    private boolean IsOff;

    LocalDate date;
    double Profit=0;


    @Override
    public void buyAnimal(Animal a) {
        if (Money<a.cost) {
            // 手动抛出 IllegalArgumentException 异常
            throw new IllegalArgumentException("InsufficientBalanceException\n");
        }
       else {
            Animals.add(a);
            System.out.print("你花费了"+a.cost+"元买了"+a.name+"\n");
            Money -= a.cost;
            Profit -= a.cost;
            System.out.print("你还剩"+Money+"元\n");
        }
        System.out.println("——————————————————————————————————————");
    }

    @Override
    public void treatCostumer(Customer C) {
        if(isOff()) { //店里有没有关门？
            System.out.println(C.name+"来到了门口");
            System.out.println("但是现在已经关门了...");
            System.out.println("——————————————————————————————————————");
        }
        else{

            boolean isNew = true;

            for(Customer c:Customers) { //检测重复顾客（不会有重名的吧
                if(c.name.equals(C.name)){
                    isNew = false;
                    break;
                }
            }

         if(isNew) {
             System.out.println("欢迎新顾客~@"+C.name);
             System.out.println("——————————————————————————————————————");
             Customers.add(C);
         }
            C.count++;
            C.date=date;
        }
    }

    public void saleAnimal(Animal a) {
        if(!Animals.isEmpty()) {
        int temp= Animals.indexOf (a);

        Animals.remove(temp);

        System.out.println("一只小动物离开了我们店：");
        System.out.println("它的信息是：");
        System.out.println((a.toString()));
        System.out.print("你获得了"+a.cost+"元\n");

        Money+=a.cost;
        Profit+=a.cost;
        System.out.println("你还剩"+Money+"元");
        System.out.println("——————————————————————————————————————");
        }
        else {
            throw new AnimalNotFoundException("AnimalNotFountException\n");
          }
    }

    @Override
    public boolean isOff() {
        if((!date.isEqual(date.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY))))){ //判断是否为周日
            return false;
        }
        else{
            return true;
        }
    }

    public void setOn(boolean on) {
        if(isOff()) {
            System.out.println("周天了，关门啦！");
            System.out.println("店里的动物有：");
            for (int i = 0; i < Animals.size(); i++) {
                Animal s = Animals.get(i);
                System.out.print(s.name+"\t");
            }

            System.out.println("\n");

            System.out.println("本周的顾客有：");
            for (int i = 0; i < Customers.size(); i++) {
                Customer c = Customers.get(i);
                System.out.print(c.name+"\t");
            }

            System.out.println("\n");

            System.out.println("你本周的收入是");
            System.out.println(Profit);
            System.out.println("——————————————————————————————————————");
        }
        else{
            System.out.println("工作日，打工了！");
            System.out.println("——————————————————————————————————————");
        }
    }


    public double getMoney() {
        return Money;
    }

    public List<Animal> getAnimals() {
        return Animals;
    }

    public List<Customer> getCustomers() {
        return Customers;
    }

    public void setMoney(double money) {
        Money = money;
    }

    public void setAnimals(List<Animal> animals) {
        Animals = animals;
    }

    public void setCustomers(List<Customer> customers) {
        Customers = customers;
    }
}
