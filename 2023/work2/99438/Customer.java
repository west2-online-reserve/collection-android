import java.time.LocalDate;

public class Customer {
    private String name;
    private int arrivalTimes;
    private LocalDate latestTime;

    // 构造函数
    public Customer() {
    }
    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getArrivalTimes() {
        return arrivalTimes;
    }

    public LocalDate getLatestTime() {
        return latestTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArrivalTimes() {
        this.arrivalTimes++;
    }

    public void setLatestTime(LocalDate latestTime) {
        this.latestTime = latestTime;
    }

    @Override
    public String toString() {
        return "Customer" + "\n"
                + "name='" + name + "\n"
                + ", arrivalTimes=" + arrivalTimes + "\n"
                + ", latestTime=" + latestTime;
    }
}
