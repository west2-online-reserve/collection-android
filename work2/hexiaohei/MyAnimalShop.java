package work2.hexiaohei;

/**
 * @version 1.0 2023.10.13
 * @author hexiaohei
 */
import java.time.LocalDate;
import java.util.LinkedList;

public class MyAnimalShop implements AnimalShop{
    private double startBalance;
    private double finalBalance;
    private boolean isClosed;
    private final LocalDate START_OPEN_TIME;
    private LocalDate today;

    LinkedList<Animal> animal;
    LinkedList<Customer> customerCome;

    /**
     * 构造fangfa
     * @param balance        余额
     * @param animal         动物列表
     * @param customerCome   顾客列表
     * @param isClosed       是否歇业
     * @param startOpenDate  开业日期
     */
    public MyAnimalShop(double balance, LinkedList<Animal> animal, LinkedList<Customer> customerCome, boolean isClosed,
                        LocalDate startOpenDate){
        this.finalBalance = balance;
        this.startBalance = balance;
        this.animal = animal;
        this.customerCome = customerCome;
        this.isClosed = isClosed;
        this.START_OPEN_TIME = startOpenDate;
        this.today = startOpenDate;
    }

    /**
     * 买进动物
     * @param animalBought 买进的动物
     */
    @Override
    public void buyNewAnimal(Animal animalBought) {
        try {
            if (finalBalance >= animalBought.cost) {
                animal.add(animalBought);
                finalBalance -= animalBought.cost;
            } else {
                throw new InsufficientBalanceException();
            }
        }
        catch (InsufficientBalanceException exception1)
        {
            exception1.printClue().printStackTrace();
        }
    }

    /**
     * 招待顾客
     * @param customer    顾客
     * @param animalSold  顾客想要的宠物
     */
    @Override
    public void treatCustomer(Customer customer, Animal animalSold) {
        if (isClosed) {
            System.out.println("不好意思，今天歇业哦");
        } else {
            customer.updateArrivalTimes(1);
            customer.setLateVisitTime(today);
            if (!customerCome.contains(customer)) {
                customerCome.add(customer);
            }

            try {
                if (animal.contains(animalSold)) {
                    System.out.println("卖出的宠物的信息为：" + animalSold.toString());
                    animal.remove(animalSold);
                    finalBalance += animalSold.price;
                } else {
                    throw new AnimalNotFoundException();
                }
            } catch (AnimalNotFoundException exception2) {
                exception2.printClue().printStackTrace();
            }
        }
    }

    /**
     * 歇业
     */
    @Override
    public void closeShop() {
        isClosed = true;
        System.out.println("现在是歇业时间啦！");

        System.out.println("今日到访的顾客名单如下：");
        for (Customer customerToday : customerCome) {
            if (customerToday.getLateVisitDate().equals(today)) {
                System.out.println(customerToday);
            }
        }

        double profit = finalBalance - startBalance;
        System.out.println("今天的利润为（单位：元）：" + profit);

        System.out.println("今天歇业后的余额为（单位：元）：" + finalBalance);
    }

    /**
     * 营业
     */
    public void openShop(){
        isClosed = false;

        // 日期往后一天（只是为了测试需要才这样设置），实际应用时可以直接today = LocalDate.now();
        today = today.plusDays(1);
        // 将上一次歇业时的余额赋值给新一次开业时的起始余额
        startBalance = finalBalance;
    }

    public double getFinalBalance() {
        return finalBalance;
    }
}
