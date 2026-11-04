package petstore;

// 功能测试

public class PetStoreTest {
    public static void main(String[] args) {
        // 正常买入和出售流程
        MyAnimalShop shop = new MyAnimalShop(1000);
        Animal dog = new ChineseRuralDog("旺财", 2, "公", true);
        Animal cat = new Cat("咪咪", 1, "母");
        Animal rabbit = new Rabbit("雪球", 1, "母");
        shop.buyAnimal(dog);
        shop.buyAnimal(cat);
        shop.buyAnimal(rabbit);
        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");
        Customer charlie = new Customer("Charlie");
        shop.serveCustomer(alice);
        shop.serveCustomer(bob);
        shop.serveCustomer(charlie);
        System.out.println("余额：" + shop.getBalance());
        System.out.println("今日利润：" + shop.getTodayProfit());
        shop.closeShop();

        // 余额不足异常
        MyAnimalShop poorShop = new MyAnimalShop(50);
        try {
            poorShop.buyAnimal(new Cat("小花", 1, "母"));
        } catch (InsufficientBalanceException e) {
            System.out.println("余额不足：" + e.getMessage());
        }

        // 没有动物异常
        try {
            shop.serveCustomer(new Customer("David"));
        } catch (AnimalNotFoundException e) {
            System.out.println("没有动物：" + e.getMessage());
        }

        // 测试 Bonus
        BonusTasks.printAlternately(
                new int[]{1, 3, 5, 7, 9},
                new int[]{2, 4, 6, 8, 10}
        );
        System.out.println(BonusTasks.isValidEmail("student@example.com"));
        System.out.println(BonusTasks.isValidEmail("student@example"));
    }
}
