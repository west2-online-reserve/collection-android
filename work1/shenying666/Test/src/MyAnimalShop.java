import java.time.LocalDate;
import java.util.ArrayList;

public class MyAnimalShop implements AnimalShop {
    private double balance;
    private double todayProfit;
    private ArrayList<Animal> animals;
    private ArrayList<Customer> customers;
    private boolean isClosed;

    public MyAnimalShop(double balance) {
        this.balance = balance;
        this.animals = new ArrayList<>();
        this.customers = new ArrayList<>();
    }
    public void buyNewAnimal(Animal animal) {
        if(isClosed){
            System.out.println("本店已打烊，请改日再购入动物。");
            return;
        }
        if(balance < animal.getPrice()){
            throw new InsufficientBalanceException("余额不足,仍差" + (animal.getPrice() - balance) + "元");
        }else {
            animals.add(animal);
            balance -= animal.getPrice();
            todayProfit -= animal.getPrice();
        }
    }
    public void serveCustomer(Customer customer) {
        if(isClosed){
            System.out.println("本店已打烊，请改日再来。");
            return;
        }
        if(animals.isEmpty()){
            throw new AnimalNotFoundException("库存告急，请改日关顾");
        }
        Customer existingCustomer = null;
        for(Customer c : customers) {
            if(c.getName().equals(customer.getName())){
                existingCustomer = c;
                break;
            }
        }
        if(existingCustomer != null){
            existingCustomer.visitShop();
        }else{
            customers.add(customer);
        }
        Animal firstAnimal = animals.get(0);
        System.out.println("售出动物：" + firstAnimal);
        todayProfit += firstAnimal.getPrice();
        balance += firstAnimal.getPrice();
        animals.remove(0);
        System.out.println("交易完成，欢迎下次光临");

    }
    public void close() {
        if(isClosed){
            System.out.println("本店已打烊");
        }else{
            isClosed = true;
            LocalDate today = LocalDate.now();
            System.out.println("本店已打烊，感谢今日到店顾客：");
            for(Customer c : customers) {
                if(c.getNewVisitDate().equals(today)){
                    System.out.println(c);
                }
            }
            System.out.println("今日利润为：" + todayProfit + "元");
        }
    }
    public void open(){
        isClosed = false;
        todayProfit = 0;
        System.out.println("本店已开始营业，欢迎光临");
    }

    public double getBalance() {
        return balance;
    }
    public double getTodayProfit() {
        return todayProfit;
    }
}
