import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        try {
            MyAnimalShop shop = new MyAnimalShop(500.0);

            // 买入动物
            shop.buyAnimal(new ChineseRuralDog("旺财", 3, "男", true));
            shop.buyAnimal(new Cat("喵喵", 2, "女"));
            shop.buyAnimal(new Rabbit("小兔", 1, "中"));

            // 招待客户
            shop.serveCustomer(new Customer("张三", 1, LocalDate.now()));
            shop.serveCustomer(new Customer("李四", 2, LocalDate.now()));

            // 关闭商店
            shop.closeShop(LocalDate.now());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
