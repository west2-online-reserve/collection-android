public class Test {
    public static void main(String[] args) {
        //创建实例，初始金额300元
        MyAnimalShop shop = new MyAnimalShop(300);
        shop.open();
        System.out.println("1.测试买入动物 ------------------------------------------------------------");
        Animal dog1 = new ChineseRuralDog("旺财", 2, "male");
        Animal cat1 = new Cat("耄耋", 3, "male");
        Animal cat2 = new Cat("丑橘", 2, "female");
        Animal bird1 = new Bird("咕咕bird", 8, "male");
        shop.buyNewAnimal(dog1);
        shop.buyNewAnimal(cat1);
        System.out.println("测试1已完成---------------------------------------------------------------");
        System.out.println("2.测试招待顾客-------------------------------------------------------------");
        Customer customer1 = new Customer("小明");
        Customer customer2 = new Customer("小红");
        Customer customer3 = new Customer("小刚");
        shop.serveCustomer(customer1);
        shop.serveCustomer(customer2);
        System.out.println("测试2已完成---------------------------------------------------------------");
        System.out.println("3.测试异常发生-------------------------------------------------------------");
        try{
            shop.serveCustomer(customer3);
        }catch (AnimalNotFoundException e){
            System.out.println(e.getMessage());
        }
        shop.buyNewAnimal(cat2);
        try{
            shop.serveCustomer(customer1);
        }catch (AnimalNotFoundException e){
            System.out.println(e.getMessage());
        }
        System.out.println(customer1); //补货后，测试老顾客到店信息是否更新
        try{
            shop.buyNewAnimal(bird1);
        }catch (InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }
        System.out.println("测试3已完成---------------------------------------------------------------");
        System.out.println("4.测试关店功能-------------------------------------------------------------");
        Customer customer4 = new Customer("小王");
        shop.close();
        shop.serveCustomer(customer4); //测试关店后顾客来访
        shop.close(); //测试重复闭店
    }
}
