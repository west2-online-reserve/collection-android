import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class MyAnimalShop implements AnimalShop{
    private double balance;
    private double newBalance;
    private List<Animal> animals = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private boolean isClosed;
    private LocalDate date;

    // 构造函数
    public MyAnimalShop(double balance, boolean isClosed, LocalDate date) {
        this.balance = balance;
        this.newBalance = newBalance;
        this.animals = animals;
        this.customers = customers;
        this.isClosed = isClosed;
        this.date = date;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // 买入动物
    @Override
    public void buyNewAnimal(Animal animal, double cost) throws InsufficientBalanceException{
        try{
            if (balance >= cost) {
                animals.add(animal);
                newBalance = balance - cost;
                System.out.println("购买" + animal.toString() + "花费" + cost + "元");
            } else {
                throw new InsufficientBalanceException("余额不足啦~");
            }
        }catch(InsufficientBalanceException e){
            System.out.println("余额不足啦~");
        }
    }

    //招待客户
    @Override
    public void treatCustomer(Customer customer, Animal animal)throws AnimalNotFoundException{
        if (isClosed) {
            System.out.println("本店尚未营业！");
            return;
        }
        try{
            customers.add(customer);
            customer.setArrivalTimes();
            customer.setLatestTime(date);
            if (animals.contains(animal)) {
                System.out.println("卖出" + animal.toString() + "盈利" + animal.getPrice() + "元");
                newBalance = balance + animal.getPrice();
                animals.remove(animal);
            } else {
                throw new AnimalNotFoundException("没找到这个小动物捏");
            }
        }catch(AnimalNotFoundException e){
            System.out.println("没找到这个小动物捏");
        }
    }

    @Override
    public void closeShop() {
        if (isClosed) {
            System.out.println("今日没开业！");
            return;
        }
        else{
            isClosed = true;
            System.out.println("打样啦~");
        }
        // 输出光顾的顾客名单
        System.out.println(date.toString() + "今日光顾的客户有：");
        for (Customer customer : customers) {
            if (customer.getLatestTime().isEqual(date)) {
                System.out.println(customer.toString());
            }
        }
        // 计算利润
        System.out.println("今日利润：" + (newBalance-balance));
        balance = newBalance;
        System.out.println("近日余额："+balance);
        // 日期往后推一天
        date = date.plusDays(1);
    }
}
