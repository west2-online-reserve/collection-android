import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // 你好我开店
        MyAnimalShop shop = new MyAnimalShop(300, true,LocalDate.now());
        // 动物们
        Beagles beagle1 = new Beagles("比格犬怎么你了", 1, "公", 300, 200, "拆家能力极强");
        Beagles beagle2 = new Beagles("让让我吧", 4, "母", 300, 200, "拆家能力一般");
        Cat cat1 =  new Cat("咪咪", 2, "母", 200, 100, false);
        Cat cat2 =  new Cat("老猫子", 6, "公", 200, 100, true);
        ChineseRuralDog dog1 = new ChineseRuralDog("旺财", 3, "公", 100, 50, true);
        ChineseRuralDog dog2 = new ChineseRuralDog("起名好难", 8, "公", 100, 50, false);
        // 客户们
        Customer customer1 = new Customer("成步堂龙一");
        Customer customer2 = new Customer("御剑怜侍");
        Customer customer3 = new Customer("雨宫莲");
        Customer customer4 = new Customer("渚薰");
        // 先买点动物
        List<Animal> animals = new ArrayList<>();
        shop.buyNewAnimal(beagle1, 200);
        shop.buyNewAnimal(cat1, 100);
        // 建一个空的客户列表
        List<Customer> customers = new ArrayList<>();

        // 第二天
        System.out.println("营业第一天！");
        shop.setClosed(false);
        shop.treatCustomer(customer1, beagle1);
        shop.treatCustomer(customer2, cat1);
        shop.buyNewAnimal(beagle2, 200);
        shop.closeShop();

        // 第二天
        System.out.println("营业第二天！");
        shop.setClosed(false);
        shop.buyNewAnimal(dog1, 50);
        shop.buyNewAnimal(dog2, 50);
        shop.treatCustomer(customer4,dog1);
        shop.treatCustomer(customer1,dog2);
        shop.closeShop();

        // 第三天（没有营业）
        System.out.println("营业第三天！今日歇业~");
        shop.closeShop();

        //第四天
        System.out.println("营业第四天！");
        shop.setClosed(false);
        shop.treatCustomer(customer2, dog2);// 将抛出AnimalNotFoundException
        shop.treatCustomer(customer3, cat2); // 将抛出AnimalNotFoundException
        shop.buyNewAnimal(beagle2, 200); // 将抛出InsufficientBalanceException
        shop.closeShop();

    }
}
