import java.time.LocalDate;

/**
 * @Author：realzhenikun
 * @Project：PetShop
 * @Date：2023/11/6
 * @Filename：Customer
 */
public class Customer {
    private String customerName;
    private int count;
    private LocalDate latestArrivalTime;

    public Customer (String customerName) {
        this.customerName = customerName;
        count = 0;
    }

    public void setTimeNow() {
        latestArrivalTime = LocalDate.now();
    }

    public void come() {
        count++;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getTime() {
        return latestArrivalTime;
    }

    @Override
    public String toString() {
        return "姓名:" + customerName + "\n到店次数:" + count + "\n最新到店时间:" + latestArrivalTime + '\n';
    }
}
