import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class MyAnimalShop implements AnimalShop {
    private double balance;
    private boolean isClosed;
    ArrayList<Animal> animals = new ArrayList<Animal>();
    ArrayList<Customer> customers = new ArrayList<Customer>();
    public MyAnimalShop(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean getClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    @Override
    public void Buyin(Animal animal) throws InsufficientBalanceException{
        if(getClosed()){
            System.out.println("Shop is closed");
        }else{
            if(getBalance() < animal.getPrice()){
                throw new InsufficientBalanceException();
            } else {
                setBalance(getBalance() - animal.getPrice());
                animals.add(animal);
                System.out.println("Buyin successful. "+animal.toString());
            }
        }
    }

    @Override
    public void EntertainCustomer(Customer customer,Animal animal) throws RuntimeException{

        if(getClosed()){
            System.out.println("Shop is closed");
        }else{
            if(!animals.contains(animal)){
                throw new AnimalNotFoundException();
            }else{
                customer.setNewestArriveTime();
                if (!customers.contains(customer)) customers.add(customer);
                animals.remove(animal);
                customer.addAnimal(animal);
                setBalance(getBalance()+animal.getPrice());
                System.out.println("Animal has been sold successfully to " + customer.getName() + ". "+animal.toString());
            }
        }
    }

    @Override
    public void CloseShop() {
        setClosed(true);
        System.out.println("Shop is closed.Have a nice day.");
        System.out.println("These are today's customers:");
        for(Customer customer : customers){
            if(Objects.equals(customer.getNewestArriveTime(), LocalDate.now())){
                System.out.println(customer.toString());
            }
        }
    }

    @Override
    public void OpenShop() {
        setClosed(false);
        System.out.println("Shop is opened.Good morning.");
    }

    @Override
    public void AddInitialAnimal(Animal animal) {
        animals.add(animal);
        System.out.println("Adding initial animal: " + animal.toString());
    }
}
