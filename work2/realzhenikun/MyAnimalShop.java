import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author：realzhenikun
 * @Project：PetShop
 * @Date：2023/11/6
 * @Filename：MyAnimalShop
 */
public class MyAnimalShop implements AnimalShop {
    private double balance;
    private double startBalance;
    private ArrayList<AbstractAnimal> animalList;
    private ArrayList<Customer> customerList;
    private boolean isOpen;

    public MyAnimalShop(double balance, ArrayList<AbstractAnimal> animalList, boolean isOpen) {
        this.balance = balance;
        startBalance = balance;
        this.animalList = animalList;
        customerList = new ArrayList<>();
        this.isOpen = isOpen;
    }

    @Override
    public void buyNewAnimal(AbstractAnimal animal) throws InsufficientBalanceException {
        if (balance < animal.getPrice()) {
            throw new InsufficientBalanceException("余额不足\n");
        } else {
            balance -= animal.getPrice();
            animalList.add(animal);
            System.out.println("购买成功");
        }
    }

    @Override
    public void entertainCustomers(Customer customer) throws AnimalNotFoundException {
        if (!isOpen) {
            System.out.println("宠物店未开业");
        } else {
            //判断是否为重复顾客，相同顾客只录入一次
            boolean isRepeat = false;
            customer.come();
            customer.setTimeNow();
            for (Customer customer1 : customerList) {
                if (customer1.getCustomerName().equals(customer.getCustomerName())) {
                    isRepeat = true;
                }
            }
            if (!isRepeat) {
                customerList.add(customer);
            }

            if (animalList.isEmpty()) {
                throw new AnimalNotFoundException("宠物已卖光");
            } else {
                //按序号选择动物购买
                System.out.println("当前宠物如下:");
                int x = 1;
                for (AbstractAnimal animal : animalList) {
                    System.out.println("序号:" + x++);
                    System.out.println(animal);
                }
                System.out.println("请输入你要购买的宠物序号:");
                Scanner s = new Scanner(System.in);
                int index = s.nextInt();
                if (index < 0 || index > animalList.size()) {
                    System.out.println("宠物序号错误，购买失败");
                } else {
                    System.out.println("卖出的动物为:\n" + animalList.get(index - 1));
                    balance += animalList.get(index - 1).getPrice();
                    animalList.remove(index - 1);
                }
            }
        }
    }

    @Override
    public void closeShop() {
        if (isOpen) {
            isOpen = false;
            if (!customerList.isEmpty()) {
                //选择当前日期光顾的顾客
                System.out.println("今日光顾的客户:");
                for (Customer customer : customerList) {
                    if (customer.getTime().equals(LocalDate.now())) {
                        System.out.println(customer);
                    }
                }
            } else {
                System.out.println("今日无客户光顾");
            }
            System.out.println("日期:" + LocalDate.now() + "\n利润:" + (balance - startBalance));
        } else {
            System.out.println("当前已歇业");
        }
    }

    @Override
    public void openShop() {
        if (isOpen) {
            System.out.println("当前已开业");
        } else {
            isOpen = true;
            startBalance = balance;
        }
    }
}