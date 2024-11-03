import java.time.LocalDate;

public class Customer {
    private String name;
    private int visitCount;
    private LocalDate lastVisitDate;

    public Customer(String name, LocalDate lastVisitDate) {
        this.name = name;
        this.visitCount = 1; 
        this.lastVisitDate = lastVisitDate;
    }

    
    public String getName() {
        return name;
    }

    public void incrementVisitCount() {
        visitCount++;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setLastVisitDate(LocalDate date) {
        lastVisitDate = date;
    }

    public LocalDate getLastVisitDate() {
        return lastVisitDate;
    }

    @Override
    public String toString() {
        return "顾客{" +
                "名字='" + name + '\'' +
                ", 到店次数=" + visitCount +
                ", 最新到店时间=" + lastVisitDate +
                '}';
    }
}
