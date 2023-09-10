package work2.PrinceSaoKe;

import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {
        MyAnimalShop shop = new MyAnimalShop(100, LocalDate.now());

        // 顾客
        Customer zhangSan = new Customer("张三");
        Customer liSi = new Customer("李四");
        Customer wangWu = new Customer("王五");
        Customer zhaoLiu = new Customer("赵六");

        // 宠物
        ChinesePastoralDog dog = new ChinesePastoralDog("旺财", 2, Sex.公, true);
        CalicoCat cat = new CalicoCat("咪咪", 1, Sex.母);
        Hamster mouse = new Hamster("吱吱", 1, Sex.公);

        // 第一天
        System.out.println("\n========== " + shop.getDate() + " ==========");
        shop.buyNewAnimal(dog, 50);
        shop.entertainCustomer(zhangSan, dog);
        shop.closeShop();

        // 第二天
        System.out.println("\n========== " + shop.getDate() + " ==========");
        shop.openShop();
        shop.buyNewAnimal(cat, 100);
        shop.entertainCustomer(liSi, cat);
        shop.closeShop();

        // 第三天
        System.out.println("\n========== " + shop.getDate() + " ==========");
        shop.openShop();
        shop.buyNewAnimal(mouse, 5);
        shop.entertainCustomer(wangWu, mouse);
        shop.closeShop();

        // 第四天
        System.out.println("\n========== " + shop.getDate() + " ==========");
        shop.openShop();
        shop.buyNewAnimal(dog, 500);
        shop.entertainCustomer(zhaoLiu, dog);
        shop.closeShop();
    }

}
