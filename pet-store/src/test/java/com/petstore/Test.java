package com.petstore;

import com.petstore.animal.ChineseRuralDog;
import com.petstore.animal.Gender;
import com.petstore.customer.Customer;
import com.petstore.exception.AnimalNotFoundException;
import com.petstore.exception.InsufficientBalanceException;
import com.petstore.shop.MyAnimalShop;

import java.time.LocalDate;

/**
 * 控制台自测类（不启动 GUI）。
 * <p>
 * 验证：买入、余额不足异常、无动物异常、招待成交、歇业结算。
 *
 * @author pet-store
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("===== 宠物店自测开始 =====\n");

        testBuyAnimal();
        testInsufficientBalance();
        testAnimalNotFound();
        testEntertainAndClose();

        System.out.println("\n===== 宠物店自测结束 =====");
    }

    /** 测试买入动物：余额扣减、列表增加 */
    private static void testBuyAnimal() {
        System.out.println("【测试1】买入动物");
        MyAnimalShop shop = new MyAnimalShop(200);
        shop.buyAnimal(new ChineseRuralDog("测试狗", 2, Gender.MALE));
        check("买入后余额应为 180.0", shop.getBalance() == 180.0, shop.getBalance());
        check("店内动物数应为 1", shop.getAnimalList().size() == 1, shop.getAnimalList().size());
        System.out.println();
    }

    /** 测试余额不足异常 */
    private static void testInsufficientBalance() {
        System.out.println("【测试2】余额不足抛出 InsufficientBalanceException");
        MyAnimalShop shop = new MyAnimalShop(200);
        boolean thrown = false;
        try {
            // 每只狗进价 20，200 最多买 10 只，第 11 只抛异常
            for (int i = 0; i < 11; i++) {
                shop.buyAnimal(new ChineseRuralDog("狗" + i, 2, Gender.MALE));
            }
        } catch (InsufficientBalanceException e) {
            thrown = true;
            System.out.println("  捕获异常: " + e.getMessage());
        }
        check("应抛出 InsufficientBalanceException", thrown, thrown);
        System.out.println();
    }

    /** 测试店内无动物时招待顾客抛出异常 */
    private static void testAnimalNotFound() {
        System.out.println("【测试3】店内无动物抛出 AnimalNotFountException");
        MyAnimalShop shop = new MyAnimalShop(200);
        boolean thrown = false;
        try {
            shop.entertainCustomer(new Customer("测试顾客", 0, LocalDate.now()));
        } catch (AnimalNotFoundException e) {
            thrown = true;
            System.out.println("  捕获异常: " + e.getMessage());
        }
        check("应抛出 AnimalNotFountException", thrown, thrown);
        System.out.println();
    }

    /** 测试招待成交 + 歇业结算 */
    private static void testEntertainAndClose() {
        System.out.println("【测试4】招待成交 + 歇业结算");
        MyAnimalShop shop = new MyAnimalShop(200);
        shop.buyAnimal(new ChineseRuralDog("旺财", 3, Gender.FEMALE)); // 余额 180，进价 20
        shop.entertainCustomer(new Customer("小明", 0, LocalDate.now())); // 卖出 100，余额 280

        check("成交后余额应为 280.0", shop.getBalance() == 280.0, shop.getBalance());
        check("店内动物数应为 0", shop.getAnimalList().isEmpty(), shop.getAnimalList().size());
        check("纪念册顾客数应为 1", shop.getCustomerList().size() == 1, shop.getCustomerList().size());

        System.out.println("  顾客信息: " + shop.getCustomerList().get(0));
        System.out.println();
        shop.close();
        System.out.println();
    }

    private static void check(String desc, boolean ok, Object actual) {
        System.out.println("  " + (ok ? "✓" : "✗") + " " + desc
                + (ok ? "" : "（实际: " + actual + "）"));
    }
}
