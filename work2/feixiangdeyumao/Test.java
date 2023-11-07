package AnimalShop;

import java.util.LinkedList;

/**
 * @version 1.1 2023.11.6
 * @author feixiangdeyumao
 */
public class Test {
    public static void main(String[] args) {
        // 初始化宠物
        Animal dog1 = new Dog("大黄", 4, "Male", 200, 100, true);
        Animal dog2 = new Dog("小白", 5, "Female", 200, 100, true);
        Animal dog3 = new Dog("安安", 1, "Female", 300, 50, true);
        Animal cat1 = new Cat("李华", 2, "Male", 200, 100);
        Animal cat2 = new Cat("将军", 6, "Male", 350, 300);
        Animal lynx1 = new Lynx("芝士", 8, "Male", 800, 600);

        // 初始化顾客
        Customer customer1 = new Customer("张三", 0);
        Customer customer2 = new Customer("李四", 1); // 已经来过一次，测试到访次数是否会增加到2
        Customer customer3 = new Customer("王五", 0);
        Customer customer4 = new Customer("老六", 6); // 没来，所以关店后不会被打印出来

        // 初始化链表
        LinkedList<Customer> customerList = new LinkedList<>();
        LinkedList<Animal> animalList = new LinkedList<>();
        // 先让商店里开始时有一只动物，列表里记录有记录一位来过的顾客
        animalList.add(dog1);
        customerList.add(customer2);

        // 初始化商店
        MyAnimalShop myAnimalShop = new MyAnimalShop(1000, 0, false, animalList, customerList);

        // 开店
        myAnimalShop.openShop();

        //进货
        try{
            myAnimalShop.buyNewAnimal(dog2);
            myAnimalShop.buyNewAnimal(cat1);
            myAnimalShop.buyNewAnimal(lynx1);
            myAnimalShop.buyNewAnimal(cat2); // 钱不够用了，会报错
        }catch (InsufficientBalanceException e){
            //System.out.println("Caught exception: " + e.getMessage());
            e.printStackTrace(); // 打印异常堆栈跟踪
        }

        // 招待顾客
        try{
            myAnimalShop.assistCustomer(customer1, dog1);
            myAnimalShop.assistCustomer(customer2, lynx1);
            myAnimalShop.assistCustomer(customer3, lynx1); // 宠物已经被买走了，会报错
            myAnimalShop.assistCustomer(customer3, dog3); // 宠物没被买进店里，会报错；该顾客“王五”一天来了两次，可测试结尾是否被打印两次名字、到访次数是否正确加二
            //这里因为在同一个try catch 里面，王五进店数量只记录了一次，两个错误也只会有一个报错
        }catch (AnimalNotFountException e){
            //System.out.println("Caught exception: " + e.getMessage());
            e.printStackTrace(); // 打印异常堆栈跟踪
        }

        // 关店
        myAnimalShop.closeShop();
    }
}
