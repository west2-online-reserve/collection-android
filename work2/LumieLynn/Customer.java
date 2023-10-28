import java.time.*;

public class Customer {
    protected String name;
    protected int customerID;
    protected int frequency;
    protected LocalDate latest = null;

    public Customer(String name, int customerID, int frequency, LocalDate latest) {
        this.name = name;
        this.customerID = customerID;
        this.frequency = frequency;
        this.latest = latest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public LocalDate getLatest() {
        return latest;
    }

    public void setLatest(LocalDate latest) {
        this.latest = latest;
    }

    @Override
    public String toString() {
        return "Name:" + getName() + "\t CustomerID:" + getCustomerID() + "\t Frequency:" + getFrequency() + "\t Latest Arrival Time:" + latest;
    }

}
