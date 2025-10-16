import java.time.LocalDate;

public class Customer {
    protected String name;
    protected int visitCount;
    protected LocalDate lastVisitDate;

    public Customer(String name) {
        this.name = name;
        this.visitCount = 1;
        this.lastVisitDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return String.format("Customer{name=%s,visitCount=%d,lastVisitDate=%s}",
                this.name, this.visitCount, this.lastVisitDate);
    }
}
