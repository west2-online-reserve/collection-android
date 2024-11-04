import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyAnimalShop implements AnimalShop {
    private double balance;
    private boolean isOpen;
    private List<Animal> animals;
    private List<Customer> customers;

    public MyAnimalShop(double initialBalance) {
        this.balance = initialBalance;
        this.isOpen = true;
        this.animals = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void buyAnimal(int animalType, String name, int age, String gender, boolean hasRabiesVaccine) throws InsufficientBalanceException {
        if (!isOpen) {
            throw new IllegalStateException("商店已关闭，无法购买动物。");
        }

        Animal animal;
        switch (animalType) {
            case 1:
                animal = new Cat(name, age, gender);
                break;
            case 2:
                animal = new ChineseFarmDog(name, age, gender, hasRabiesVaccine);
                break;
            case 3:
                animal = new Monkey(name, age, gender);
                break;
            default:
                throw new IllegalArgumentException("无效的动物类型");
        }

        double animalCost = animal.getPrice();
        if (balance < animalCost) {
            throw new InsufficientBalanceException("余额不足，无法购买动物。");
        }

        animals.add(animal);
        balance -= animalCost;
        System.out.println("买入动物: " + animal);
        System.out.println("当前余额: " + balance);
    }

    public Animal attendCustomer(Customer customer) throws AnimalNotFoundException {
        if (!isOpen) {
            throw new IllegalStateException("商店已关闭，无法接待顾客。");
        }
    
        LocalDate today = LocalDate.now();
        boolean isReturningCustomer = false;
    
    
        for (Customer existingCustomer : customers) {
            if (existingCustomer.getName().equals(customer.getName())) {
                isReturningCustomer = true;
                
                
                existingCustomer.incrementVisitCount();
    
               
                if (existingCustomer.getLastVisitDate().isBefore(today)) {
                    existingCustomer.setLastVisitDate(today);
                }
    
                System.out.println("欢迎回来: " + existingCustomer);
                return attendToAnimalSelection(existingCustomer);
            }
        }
    
      
        if (!isReturningCustomer && customer.getLastVisitDate().isEqual(today)) {
            customers.add(customer);
            System.out.println("招待新顾客: " + customer);
            return attendToAnimalSelection(customer);
        } else {
            System.out.println("该顾客的来访日期不是今天，跳过记录: " + customer.getName());
            return null;
        }
    }
    
    

    private Animal attendToAnimalSelection(Customer customer) throws AnimalNotFoundException {
        if (animals.isEmpty()) {
            throw new AnimalNotFoundException("店内没有动物可供出售。");
        }

        System.out.println("可供购买的动物列表：");
        for (int i = 0; i < animals.size(); i++) {
            System.out.println((i + 1) + ". " + animals.get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择要购买的动物编号：");
        int choice = scanner.nextInt() - 1;

        if (choice < 0 || choice >= animals.size()) {
            System.out.println("无效的选择，出售第一个动物。");
            choice = 0;
        }

        Animal animal = animals.remove(choice); 
        balance += animal.getPrice();
        System.out.println("出售动物: " + animal);
        System.out.println("当前余额: " + balance);

        return animal;
    }

    public void closeShop() {
        isOpen = false;
        LocalDate today = LocalDate.now();
        System.out.println("商店已关闭");
        System.out.println("今日客户列表 (只显示今天到店的): ");
        for (Customer customer : customers) {
            if (customer.getLastVisitDate().isEqual(today)) {
                System.out.println(customer);
            }
        }
        System.out.println("今日结束时余额: " + balance);
        System.out.println("今日利润: 0");
        customers.clear(); 
    }

    public void openShop() {
        isOpen = true;
        System.out.println("商店已开启");
    }
}
