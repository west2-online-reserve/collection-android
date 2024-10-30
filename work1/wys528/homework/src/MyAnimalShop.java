import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MyAnimalShop implements AnimalShop {
    private double balance;
    private List<Animal> animalList;
    private List<Customer> customerList;
    private boolean isOpen;

    public MyAnimalShop(double initialBalance) {
        this.balance = initialBalance;
        this.animalList = new ArrayList<>();
        this.customerList = new ArrayList<>();
        this.isOpen = true;
    }

    @Override
    public void buyAnimal(Animal animal) throws InsufficientBalanceException {
        if (!isOpen) {
            throw new IllegalStateException("商店已歇业！");
        }
        if (balance < animal.price) {
            throw new InsufficientBalanceException("余额不足，无法购买此动物！");
        }
        animalList.add(animal);
        balance -= animal.price;
    }

    @Override
    public void serveCustomer(Customer customer) {
        if (!isOpen) {
            throw new IllegalStateException("商店已歇业！");
        }
        customerList.add(customer);

        if (animalList.isEmpty()) {
            throw new AnimalNotFoundException("店内没有动物可供购买！");
        }
        Animal animal = animalList.remove(0); // 出售第一只动物
        balance += animal.price;
    }

    @Override
    public void closeShop(LocalDate date) {
        if (!isOpen) {
            throw new IllegalStateException("商店已歇业！");
        }
        isOpen = false;
        System.out.println("店内客户信息:");
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
        System.out.println("今天的利润是: " + balance);
        customerList.clear(); // 清空客户列表
    }
}
