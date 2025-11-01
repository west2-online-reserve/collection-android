package com.example.animalshop;

import java.time.LocalDate;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        // 创建宠物店实例，初始余额1000元
        MyAnimalShop petShop = new MyAnimalShop(1000.0);

        System.out.println("=== 宠物店系统测试开始 ===\n");

        try {
            // 测试买入动物
            System.out.println("1. 测试买入动物:");
            Animal dog = new ChineseRuralDog("小黑", 2, "公", true);
            Animal cat = new Cat("咪咪", 1, "母", "白色");


            petShop.purchaseAnimal(dog);
            petShop.purchaseAnimal(cat);


            System.out.println("\n当前余额: " + petShop.getBalance() + "元");
            System.out.println("动物数量: " + petShop.getAnimalList().size() + "只");

            // 测试招待客户
            System.out.println("\n2. 测试招待客户:");
            Customer customer1 = new Customer("张三");
            Customer customer2 = new Customer("李四");

            petShop.serveCustomer(customer1);
            petShop.serveCustomer(customer2);

            System.out.println("\n当前余额: " + petShop.getBalance() + "元");
            System.out.println("动物数量: " + petShop.getAnimalList().size() + "只");
            System.out.println("客户数量: " + petShop.getCustomerList().size() + "位");

            // 测试歇业
            System.out.println("\n3. 测试歇业:");
            petShop.closeBusiness();

            // 测试异常情况
            System.out.println("\n4. 测试异常情况:");

            // 测试余额不足异常
            try {
                Animal expensiveDog = new ChineseRuralDog("大黑", 3, "公", true);
                // 修改价格为很高来触发异常
                // 注意：这里因为price是protected，在实际中需要通过构造方法设置
                petShop.purchaseAnimal(expensiveDog);
            } catch (InsufficientBalanceException e) {
                System.out.println("捕获到余额不足异常: " + e.getMessage());
            }

            // 测试动物不存在异常
            try {
                // 先把所有动物卖完
                while (!petShop.getAnimalList().isEmpty()) {
                    Customer customer = new Customer("测试客户");
                    petShop.serveCustomer(customer);
                }
                // 现在尝试在空店里卖动物
                Customer customer = new Customer("王五");
                petShop.serveCustomer(customer);
            } catch (AnimalNotFoundException e) {
                System.out.println("捕获到动物不存在异常: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("测试过程中出现异常: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\n=== 宠物店系统测试结束 ===");
    }
}
