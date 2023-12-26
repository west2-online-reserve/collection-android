import java.time.LocalDate;
import java.util.ArrayList; // 引入ArrayList类
public class MyAnimalShop  implements AnimalShop {


    private double balance;   //余额

    private boolean IfOpen;   //是否营业
    private double profit = 0;   //利润


    // 创建一个新的ArrayList
    ArrayList<String> animals = new ArrayList<String>();  //动物列表
    ArrayList<String> customers = new ArrayList<String>();  //顾客列表


    public MyAnimalShop(double balance, boolean IfOpen, double profit) {
        this.balance = balance;
        this.IfOpen = true;
        this.profit = profit;

    }


    /**
     * 功能1：买入动物
     */

    public void buyNewAnimal(Animal animal) {
        if (IfOpen == false) {
            System.out.println("关门啦");
            return;
        }
        if (balance < animal.price) {
            System.out.println("余额不足");
            throw new InsufficientBalanceException("余额不足！"); //抛出余额不足异常
        } else {
            balance = balance - animal.cost;
            profit = profit - animal.cost;
            animals.add(animal);
            System.out.println("成功购入");
            System.out.println("新动物信息:" + animal.toString());
        }
    }

    /**
     * 功能2：招待顾客
     */

    public void TendOnCustomers(Customer customer, Animal animal) {
        if (IfOpen == false) {
            System.out.println("关门啦");
            return;
        } else {
            System.out.println("欢迎光临");
        }
        if (customer.date == Null) {
            customers.add(customer);
        }
        if (animals.isEmpty()) {
            throw new AnimalNotFoundException("店内暂无动物"); //抛出没有动物异常
        } else {
            LocalDate date = LocalDate.now();
            animals.toString();
            balance = balance + animal.price;   //钱入账
            profit = profit + animal.price;
            animals.remove(animal);   //移除动物

        }


    }


    /**
     * 功能3：歇业
     */
    @Override
    public void close() {          //歇业
        IfOpen = false;

        //输出当天光顾的客户的列表信息
        for (String customer : customers) {
            if (customer.date.equals(Today)) {   // 使用增强for循环遍历ArrayList的内容
                System.out.println(customer);
            }
            //输出一天的利润
            System.out.println("今天的利润为" + profit);


        }
    }
}













