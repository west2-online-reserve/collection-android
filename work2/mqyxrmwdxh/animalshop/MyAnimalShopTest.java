package work2.mqyxrmwdxh.animalshop;

import java.time.LocalDate;

/**
 * @author 32867
 */
public class MyAnimalShopTest {
    public static void main(String[] args) {
        MyAnimalShop shop = new MyAnimalShop("11号宠物店", 500, LocalDate.now());

        Customer customer1 = new Customer("1号");
        Customer customer2 = new Customer("2号");
        Customer customer3 = new Customer("3号");
        Customer customer4 = new Customer("4号");
        Customer customer5 = new Customer("5号");

        Cat garfield = new Cat("咖啡", 5, 15.0, SexEnum.MALE, "咖啡猫");
        garfield.setPrice(50.0);
        Cat ragdoll = new Cat("布偶", 3, 5.3, SexEnum.FEMALE, "布偶猫");
        ChineseRuralDog black = new ChineseRuralDog(false, "小黑", 6, 40.0, SexEnum.FEMALE);
        ChineseRuralDog white = new ChineseRuralDog(true, "小白", 6, 32.9, SexEnum.MALE);
        Tortoise bastard = new Tortoise("王八哥", 40, 20.3, SexEnum.MALE, 1000.0, 18);

        try {
            //First Day
            shop.openShop();

            //InsufficientBalanceException
            shop.purchaseAnimal(bastard, 1000);

            shop.purchaseAnimal(black, 50);
            shop.entertainCustomer(customer2, black);
            shop.closeShop();
            System.out.println("*************************************");

            //Second Day
            shop.closeShop();
            shop.openShop();

            //AnimalNotFountException
            shop.entertainCustomer(customer1, bastard);
            shop.entertainCustomer(customer1, black);

            shop.purchaseAnimal(white, 60);
            shop.purchaseAnimal(garfield, 20);
            shop.closeShop();
            System.out.println("*************************************");

            //Third Day
            shop.openShop();
            shop.purchaseAnimal(ragdoll, 150);

            //AnimalNotFountException
            shop.entertainCustomer(customer4, white);

            shop.closeShop();
            System.out.println("*************************************");

            //Fourth Day
            shop.openShop();
            shop.entertainCustomer(customer5, ragdoll);

            //AnimalNotFountException
            shop.entertainCustomer(customer5, bastard);

            shop.entertainCustomer(customer5, garfield);
            shop.closeShop();
            System.out.println("*************************************");

        } catch (InsufficientBalanceException e1) {
            e1.alarm().printStackTrace();
        } catch (AnimalNotFountException e2) {
            e2.alarm().printStackTrace();
        }

        //Test Customer
        customer1.getPetList();
        customer2.getPetList();
        customer3.getPetList();
        customer4.getPetList();
        customer5.getPetList();
    }


}
