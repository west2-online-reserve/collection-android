import java.time.LocalDate;
import java.util.ArrayList;

public class MyAnimalShop implements AnimalShop {
    protected final double COST_RATE = 0.5;
    protected double balance;
    protected double todayProfit;
    protected ArrayList<Animal> stockAnimals;
    protected ArrayList<Customer> visitedCustomers;
    protected boolean isOpen;

    public MyAnimalShop(double balance, ArrayList<Animal> stockAnimals) {
        this.balance = balance;
        this.stockAnimals = stockAnimals;
        this.visitedCustomers = new ArrayList<>();
        this.isOpen = true;
        this.todayProfit = 0.0;
    }

    @Override
    public void buyNewAnimal(Animal animal) {
        var cost = animal.price * COST_RATE;
        if (cost > this.balance) {
            throw new InsufficientBalanceException(balance, cost);
        } else {
            this.balance -= cost;
            this.todayProfit -= cost;
            stockAnimals.add(animal);
            System.out.printf("[PetShop]Purchase a new animal: %s\n", animal);
            System.out.printf("[PetShop]Balance -$%.2f\n", cost);
        }

    }

    @Override
    public void entertainCustomer(String customerName, String animalName) {
        if (!this.isOpen) {
            throw new ShopNotOpenException();
        }

        var existCustomers = this.visitedCustomers.stream()
                .filter(c -> c.name.equals(customerName))
                .toList();
        if (existCustomers.isEmpty()) {
            visitedCustomers.add(new Customer(customerName));
        } else {
            var existCustomer = existCustomers.getFirst();
            existCustomer.visitCount++;
            existCustomer.lastVisitDate = LocalDate.now();
        }

        var targetAnimals = this.stockAnimals.stream()
                .filter(animal -> animal.name.equals(animalName))
                .toList();
        if (targetAnimals.isEmpty()) {
            throw new AnimalNotFoundException(animalName);
        }

        var targetAnimal = targetAnimals.getFirst();
        this.balance += targetAnimal.price;
        this.todayProfit += targetAnimal.price;
        this.stockAnimals.remove(targetAnimal);

        System.out.printf("[PetShop]Customer %s buy a animal: %s\n", customerName, targetAnimal);
        System.out.printf("[PetShop]Balance +$%.2f\n", targetAnimal.price);
    }

    @Override
    public void close() {
        if (!this.isOpen) {
            throw new ShopNotOpenException();
        }
        this.isOpen = false;

        var sb = new StringBuilder();
        sb.append("You close your pet shop!\n");
        sb.append("--------------------------\n");
        sb.append("Today Customers:\n");
        for (var customer : this.visitedCustomers) {
            if (customer.lastVisitDate.equals(LocalDate.now())) {
                sb.append(customer).append("\n");
            }
        }
        sb.append("--------------------------\n");
        sb.append(String.format("Today Profit: $%.2f\n", this.todayProfit));
        sb.append(String.format("Current Balance: $%.2f\n", this.balance));
        todayProfit = 0.0;
        System.out.print(sb);
    }
}
