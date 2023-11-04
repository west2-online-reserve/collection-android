import java.time.LocalDate;

public class Customer {
    public Customer(String name, int times) {
        this.name = name;
        this.times = times;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public LocalDate getLastArriveDate() {
        return lastArriveDate;
    }

    public void setLastArriveDate(LocalDate lastArriveDate) {
        this.lastArriveDate = lastArriveDate;
    }

    private String name;

    public int getTimes() {
        return times;
    }

    private int times;
    private LocalDate lastArriveDate;

    @Override
    public String toString() {
        return "顾客姓名：" + name + ",到店次数：" + times + "最近到店时间：" + lastArriveDate;
    }
}
