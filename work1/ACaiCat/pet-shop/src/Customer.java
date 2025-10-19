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

    public String getName() {
        return this.name;
    }

    public int getVisitCount() {
        return this.visitCount;
    }

    public LocalDate getLastVisitDate() {
        return this.lastVisitDate;
    }

    public void processVisite() {
        this.visitCount++;
        this.lastVisitDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return String.format("Customer{name=%s,visitCount=%d,lastVisitDate=%s}",
                this.name, this.visitCount, this.lastVisitDate);
    }
}
