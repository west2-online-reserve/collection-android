import java.util.ArrayList;
/**
 * @Author：realzhenikun
 * @Project：PetShop
 * @Date：2023/11/6
 * @Filename：MyAnimalShopTest
 */
public class MyAnimalShopTest {
    public static void main(String[] args) {
        //宠物店原有宠物
        ArrayList<AbstractAnimal> animalList = new ArrayList<>();
        animalList.add(new Cat("Tom", 3, "雄"));

        MyAnimalShop petShop = new MyAnimalShop(200, animalList, true);

        Customer customer1 = new Customer("小A");
        Customer customer2 = new Customer("小B");
        Customer customer3 = new Customer("小C");
        Customer customer4 = new Customer("小D");
        Customer customer5 = new Customer("小E");

        ChineseRuralDog animal1 = new ChineseRuralDog("帕克", 2, "雄", true);
        ChineseRuralDog animal2 = new ChineseRuralDog("斯派克", 4, "雄", false);
        Cat animal3 = new Cat("二尾", 5, "雌");
        Cat animal4 = new Cat("coke", 1, "雄");

        //测试buyNewAnimal
        System.out.println("当前测试buyNewAnimal方法");
        try {
            petShop.buyNewAnimal(animal1);
            petShop.buyNewAnimal(animal3);
            petShop.buyNewAnimal(animal2);
        } catch (InsufficientBalanceException exception) {
            System.out.println(exception.toString());
        }
        //测试entertainCustomers
        System.out.println("当前测试entertainCustomers方法");
        petShop.closeShop();
        petShop.openShop();

        try {
            petShop.entertainCustomers(customer1);
            petShop.entertainCustomers(customer1);
            petShop.entertainCustomers(customer2);
        } catch (AnimalNotFoundException exception) {
            System.out.println(exception.toString());
        }

        //测试closeShop和openShop
        System.out.println("当前测试closeShop和openShop方法");
        petShop.closeShop();
        petShop.openShop();
        petShop.closeShop();

        //组合测试1
        System.out.println("当前为组合测试1");
        MyAnimalShop petShop1 = new MyAnimalShop(200, animalList, true);
        try {
            petShop1.buyNewAnimal(animal3);
            petShop1.closeShop();
            petShop1.entertainCustomers(customer1);
        } catch (InsufficientBalanceException exception) {
            System.out.println(exception.toString());
        } catch (AnimalNotFoundException exception) {
            System.out.println(exception.toString());
        }

        //组合测试2
        System.out.println("当前为组合测试2");
        MyAnimalShop petShop2 = new MyAnimalShop(9999, animalList, true);
        try {
            petShop2.buyNewAnimal(animal1);
            petShop2.buyNewAnimal(animal2);
            petShop2.buyNewAnimal(animal3);
            petShop2.buyNewAnimal(animal4);
            petShop2.entertainCustomers(customer1);
            petShop2.entertainCustomers(customer1);
            petShop2.entertainCustomers(customer2);
            petShop2.entertainCustomers(customer3);
            petShop2.entertainCustomers(customer4);
            petShop2.entertainCustomers(customer5);
            petShop2.closeShop();
        } catch (InsufficientBalanceException exception) {
            System.out.println(exception.toString());
        } catch (AnimalNotFoundException exception) {
            System.out.println(exception.toString());
        }
    }
}