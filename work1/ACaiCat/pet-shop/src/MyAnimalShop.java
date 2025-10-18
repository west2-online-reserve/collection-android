import java.time.LocalDate;
import java.util.ArrayList;

public class MyAnimalShop implements AnimalShop {
    protected final double COST_RATE = 0.5;
    protected double balance;
    protected double todayProfit;
    protected ArrayList<Animal> stockAnimals;
    protected ArrayList<Customer> visitedCustomers;
    protected boolean open;

    public boolean isOpen() {
        return this.open;
    }

    public ArrayList<Animal> getStockAnimals() {
        return this.stockAnimals;
    }

    public ArrayList<Customer> getVisitedCustomers() {
        return this.visitedCustomers;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getTodayProfit() {
        return this.todayProfit;
    }

    public void cleanTodayProfit() {
        this.todayProfit = 0.0;
    }

    public void processIncome(double amount) {
        this.balance += amount;
        this.todayProfit += amount;
    }

    public void processCost(double amount) {
        this.balance -= amount;
        this.todayProfit -= amount;
    }


    public MyAnimalShop(double balance, ArrayList<Animal> stockAnimals) {
        this.balance = balance;
        this.stockAnimals = stockAnimals;
        this.visitedCustomers = new ArrayList<>();
        this.open = true;
        this.todayProfit = 0.0;
    }

    @Override
    public void buyNewAnimal(Animal animal) {
        var cost = animal.getPrice() * COST_RATE;
        if (cost > this.getBalance()) {
            throw new InsufficientBalanceException(this.getBalance(), cost);
        } else {
            this.processCost(cost);
            this.getStockAnimals().add(animal);
            System.out.printf("[PetShop]Purchase a new animal: %s\n", animal);
            System.out.printf("[PetShop]Balance -$%.2f\n", cost);
        }

    }

    @Override
    public void entertainCustomer(String customerName, String animalName) {
        if (!this.open) {
            throw new ShopNotOpenException();
        }

        var existCustomers = this.getVisitedCustomers().stream()
                .filter(c -> c.getName().equals(customerName))
                .toList();
        if (existCustomers.isEmpty()) {
            this.getVisitedCustomers().add(new Customer(customerName));
        } else {
            var existCustomer = existCustomers.getFirst();
            existCustomer.processVisite();
        }

        var targetAnimals = this.getStockAnimals().stream()
                .filter(animal -> animal.getName().equals(animalName))
                .toList();
        if (targetAnimals.isEmpty()) {
            throw new AnimalNotFoundException(animalName);
        }

        var targetAnimal = targetAnimals.getFirst();
        this.processIncome(targetAnimal.getPrice());
        this.getStockAnimals().remove(targetAnimal);

        System.out.printf("[PetShop]Customer %s buy a animal: %s\n", customerName, targetAnimal);
        System.out.printf("[PetShop]Balance +$%.2f\n", targetAnimal.getPrice());
    }

    @Override
    public void close() {
        if (!this.isOpen()) {
            throw new ShopNotOpenException();
        }
        this.setOpen(false);

        var sb = new StringBuilder();
        sb.append("You close your pet shop!\n");
        sb.append("--------------------------\n");
        sb.append("Today Customers:\n");
        for (var customer : this.getVisitedCustomers()) {
            if (customer.getLastVisitDate().equals(LocalDate.now())) {
                sb.append(customer).append("\n");
            }
        }
        sb.append("--------------------------\n");
        sb.append(String.format("Today Profit: $%.2f\n", this.getTodayProfit()));
        sb.append(String.format("Current Balance: $%.2f\n", this.getBalance()));
        this.cleanTodayProfit();
        System.out.print(sb);
    }
}
