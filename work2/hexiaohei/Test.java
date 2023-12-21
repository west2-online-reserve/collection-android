package work2.hexiaohei;

/**
 * @version 1.0 2023.10.13
 * @author hexiaohei
 */
import java.time.LocalDate;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        // 有哪些动物
        Animal animal1 = new Cat("喵喵",2, "雌", 100, 300, true);
        Animal animal2 = new ChineseRuralDog("笨柴", 2, "雄", 100, 200, true);
        Animal animal3 = new Hamster("绿豆", 1, "雌", 80, 160, true);
        Animal animal4 = new Hamster("黄豆", 1, "雄", 80, 160, true);
        Animal animal5 = new Hamster("红豆", 1, "雌", 80, 160, true);
        Animal animal6 = new Hamster("黑豆", 1, "雄", 80, 160, true);
        Animal animal7 = new Cat("嘻嘻",2, "雌", 100, 300, true);
        Animal animal8 = new Cat("哈哈",2, "雄", 100, 300, true);
        Animal animal9 = new ChineseRuralDog("蹦蹦", 2, "雄", 100, 200, true);

        // 有哪些客户
        Customer customer1 = new Customer("小明");
        Customer customer2 = new Customer("小德");
        Customer customer3 = new Customer("小至");
        Customer customer4 = new Customer("小诚");

        // 初始化一个宠物列表，在其中预先放入一只宠物
        LinkedList<Animal> animal = new LinkedList<>();
        animal.add(animal1);

        // 创建一个空的顾客列表
        LinkedList<Customer> customerCome = new LinkedList<>();

        // 实例化我自己的宠物店
        MyAnimalShop myAnimalShop = new MyAnimalShop(600, animal, customerCome, true, LocalDate.of(2023,10,18));
        // 此处的日期可以为LocalDate.now()来获取当前日期，我只是为了方便测试，才自定义了一个

        // 第一天
        System.out.println("\n==第一天==");
        myAnimalShop.openShop();
        // 买入动物
        myAnimalShop.buyNewAnimal(animal2);
        myAnimalShop.buyNewAnimal(animal3);
        myAnimalShop.buyNewAnimal(animal4);
        myAnimalShop.buyNewAnimal(animal5);
        myAnimalShop.buyNewAnimal(animal6);
        // 异常测试
        try {
            myAnimalShop.buyNewAnimal(animal7);
        } catch (InsufficientBalanceException e) {
            System.out.println("买不了，囊中羞涩");
        }
        try {
            myAnimalShop.buyNewAnimal(animal8);
        } catch (InsufficientBalanceException e) {
            System.out.println("买不了，囊中羞涩");
        }
        // 查看买完动物后的余额
        System.out.println("当前余额为（单位：元）：\n" + myAnimalShop.getFinalBalance());
        // 查看此时的动物列表
        System.out.println("此时的动物列表如下：\n" + animal);
        System.out.println("==============================");
        // 招待客户
        myAnimalShop.treatCustomer(customer1,animal1);
        myAnimalShop.treatCustomer(customer2,animal2);
        // 查看当前的顾客列表
        System.out.println("此时的顾客列表如下：\n" + customerCome);
        // 查看当前的宠物列表
        System.out.println("此时的动物列表如下：\n" + animal);
        System.out.println("================================");
        // 歇业
        myAnimalShop.closeShop();

        // 第二天
        System.out.println("\n==第二天==");
        myAnimalShop.openShop();
        
        myAnimalShop.treatCustomer(customer3,animal4);
        myAnimalShop.treatCustomer(customer4,animal5);   
        
        System.out.println("此时的动物列表如下：\n" + animal);
        System.out.println("================================");
        
        myAnimalShop.closeShop();

        // 第三天
        System.out.println("\n==第三天==");
        myAnimalShop.openShop();
        
        myAnimalShop.treatCustomer(customer3,animal3);
        // 异常测试
        try {
            myAnimalShop.treatCustomer(customer3,animal3);
        } catch (Exception e) {
            System.out.println("不好意思，该宠物已被买走");
        }
        try {
            myAnimalShop.treatCustomer(customer4,animal5);
        } catch (Exception e) {
            System.out.println("不好意思，该宠物已被买走");
        }
        
        myAnimalShop.closeShop();

        // 第四天
        System.out.println("\n==第四天==");
        myAnimalShop.openShop();
        
        myAnimalShop.treatCustomer(customer1,animal7);
        myAnimalShop.treatCustomer(customer4,animal6);
        
        System.out.println("此时的顾客列表如下：\n" + customerCome);
        
        System.out.println("此时的动物列表如下：\n" + animal);
        System.out.println("================================");
        
        myAnimalShop.closeShop();

        // 第五天（没营业）
        System.out.println("\n==第五天==");
        
        myAnimalShop.buyNewAnimal(animal9);   // 我的理解是，歇业也可以买进动物，但是不能招待顾客
        
        myAnimalShop.treatCustomer(customer1, animal9);  // 会返回提示信息并无法成功招待

    }
}
