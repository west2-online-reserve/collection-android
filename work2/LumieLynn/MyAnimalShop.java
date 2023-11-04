import java.time.LocalDate;
import java.util.ArrayList;

public class MyAnimalShop implements AnimalShop {
    private double balance;
    private double profit = 0;
    private boolean isOpen;

    private LocalDate date = LocalDate.now();
    private ArrayList<Animal> animals = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();

    public MyAnimalShop(double balance,boolean isOpen) {
        this.balance = balance;
        this.isOpen = isOpen;
    }

    @Override
    public void addInitialAnimal(Animal animal) {
        animals.add(animal);
        System.out.println(animal.getName()+" is added to your shop.");
    }

    @Override
    public void buyNewAnimal(Animal animal) throws InsufficientBalanceException {
        if(!isOpen) {
            System.out.println("The shop is not opened.");
            return;
        }
        if(balance<animal.getPrice()) {
                throw new InsufficientBalanceException("Failed! Balance is lower than price.");
            }
            else{
                animals.add(animal);
                balance-=animal.getPrice();
                profit-=animal.getPrice();
                System.out.println("Successful. You've bought :"+animal.toString()+"\nYour balance remains "+balance+".");
            }
    }

    @Override
    public void entertainCustomer(Customer customer, Animal animal) throws AnimalNotFoundException {
        if(!isOpen) {
            System.out.println("The shop is not opened.");
        } else {
            if (!customers.contains(customer)) {
                customers.add(customer);
            }
            if(customer.getFrequency() == 0) {
                System.out.println("Hello, " + customer.getName() + ". You are a new guest of this Animal Shop!");
            } else {
                System.out.println("Welcome,"+customer.getName()+". Seems that you've come to our shop before.");
            }
            customer.updateFrequency(customer.getFrequency() + 1);
            customer.updateLatest(date);
            if (animals.contains(animal)) {
                    balance += animal.getPrice();
                    profit += animal.getPrice();
                    System.out.println(customer.getName()+" bought "+animal.getName() + " Successfully!");
                    System.out.println(animal.toString());
                    animals.remove(animal);
                } else {
                    throw new AnimalNotFoundException("Sorry," + customer.getName() + ", our shop don't have this animal.");
                }
        }
    }

    @Override
    public void closeShop() {
        if (isOpen) {
            isOpen = false;
            System.out.println("The shop is closed successfully.");
            System.out.println("The customers who visited today are as follows:");
            for (int i = 0; i < customers.size(); i++) {
                Customer cus = customers.get(i);
                LocalDate latest = cus.getLatest();
                if(latest.equals(date)) {
                    System.out.println(cus.toString());
                }
            }
            System.out.println("Profit this time:" + profit + ";In-store balance:"+balance);
            profit = 0;

        } else {
            System.out.println("The shop is already closed. Do not repeat the closing.");
        }
    }

    @Override
    public void openShop() {
        if (isOpen) {
            System.out.println("The shop is already open. Do not repeat the opening.");
        } else {
            isOpen = true;
            System.out.println("The store is open. Have a good day!");
        }

    }
}
