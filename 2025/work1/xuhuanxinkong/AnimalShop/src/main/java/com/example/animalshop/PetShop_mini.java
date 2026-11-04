package com.example.animalshop;

import java.util.Scanner;

/**
 * 交互式宠物店管理系统
 */
public class PetShop_mini {
    private MyAnimalShop petShop;
    private Scanner scanner;

    public PetShop_mini() {
        this.scanner = new Scanner(System.in);
        initializeSystem();
    }

    private void initializeSystem() {
        System.out.println("🐾 欢迎使用宠物店管理系统 🐾");
        System.out.print("请输入宠物店的初始资金: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); // 消耗换行符

        petShop = new MyAnimalShop(initialBalance);
        System.out.println("宠物店初始化成功！初始资金: " + initialBalance + "元");
    }

    public void start() {
        while (true) {
            showMainMenu();
            int choice = getIntInput("请选择操作: ");

            switch (choice) {
                case 1:
                    purchaseAnimalMenu();
                    break;
                case 2:
                    serveCustomerMenu();
                    break;
                case 3:
                    viewAnimals();
                    break;
                case 4:
                    viewCustomers();
                    break;
                case 5:
                    viewShopInfo();
                    break;
                case 6:
                    closeBusiness();
                    break;
                case 0:
                    System.out.println("感谢使用宠物店管理系统，再见！");
                    return;
                default:
                    System.out.println("❌ 无效选择，请重新输入！");
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("           宠物店管理系统");
        System.out.println("=".repeat(40));
        System.out.println("1. 买入新动物");
        System.out.println("2. 招待客户");
        System.out.println("3. 查看店内动物");
        System.out.println("4. 查看客户列表");
        System.out.println("5. 查看店铺信息");
        System.out.println("6. 歇业结算");
        System.out.println("0. 退出系统");
        System.out.println("=".repeat(40));
    }

    private void purchaseAnimalMenu() {
        System.out.println("\n 买入新动物");
        System.out.println("1. 中华田园犬 (100元)");
        System.out.println("2. 猫咪 (200元)");
        System.out.println("3. 鹦鹉 (150元)");
        System.out.println("4. 返回主菜单");

        int choice = getIntInput("请选择动物类型: ");
        if (choice == 4) return;

        try {
            System.out.print("请输入动物名字: ");
            String name = scanner.nextLine();

            int age = getIntInput("请输入年龄: ");

            System.out.print("请输入性别(公/母): ");
            String gender = scanner.nextLine();

            Animal animal = null;
            switch (choice) {
                case 1:
                    System.out.print("是否已注射疫苗(true/false): ");
                    boolean vaccinated = scanner.nextBoolean();
                    scanner.nextLine();
                    animal = new ChineseRuralDog(name, age, gender, vaccinated);
                    break;
                case 2:
                    System.out.print("请输入颜色: ");
                    String color = scanner.nextLine();
                    animal = new Cat(name, age, gender, color);
                    break;

                default:
                    System.out.println("❌ 无效选择！");
                    return;
            }

            petShop.purchaseAnimal(animal);
            System.out.println("✅ 成功买入动物！");

        } catch (InsufficientBalanceException e) {
            System.out.println("❌ 买入失败: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ 输入错误: " + e.getMessage());
        }
    }

    private void serveCustomerMenu() {
        System.out.println("\n👥 招待客户");

        System.out.print("请输入客户姓名: ");
        String customerName = scanner.nextLine();

        Customer customer = new Customer(customerName);

        try {
            petShop.serveCustomer(customer);
            System.out.println("✅ 成功招待客户并完成交易！");
        } catch (AnimalNotFoundException e) {
            System.out.println("❌ 招待失败: " + e.getMessage());
        }
    }

    private void viewAnimals() {
        System.out.println("\n🐶 店内动物列表");
        var animals = petShop.getAnimalList();

        if (animals.isEmpty()) {
            System.out.println("暂无动物");
            return;
        }

        for (int i = 0; i < animals.size(); i++) {
            System.out.println((i + 1) + ". " + animals.get(i));
        }
    }

    private void viewCustomers() {
        System.out.println("\n👥 客户列表");
        var customers = petShop.getCustomerList();

        if (customers.isEmpty()) {
            System.out.println("暂无客户记录");
            return;
        }

        customers.forEach(System.out::println);
    }

    private void viewShopInfo() {
        System.out.println("\n🏪 店铺信息");
        System.out.println("当前余额: " + petShop.getBalance() + "元");
        System.out.println("动物数量: " + petShop.getAnimalList().size() + " 只");
        System.out.println("客户数量: " + petShop.getCustomerList().size() + " 位");
        System.out.println("营业状态: " + (petShop.isInBusiness() ? "营业中" : "已歇业"));
    }

    private void closeBusiness() {
        System.out.println("\n🏁 歇业结算");
        petShop.closeBusiness();
    }

    private int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("❌ 请输入有效的数字！");
            scanner.next();
            System.out.print(prompt);
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public static void main(String[] args) {
        PetShop_mini system = new PetShop_mini();
        system.start();
    }
}
