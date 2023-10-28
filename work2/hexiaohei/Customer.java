package work2.hexiaohei;

/**
 * @version 1.0 2023.10.13
 * @author hexiaohei
 */
import java.time.LocalDate;

public class Customer {
    private final String name;
    private int arrivalTimes;
    private LocalDate lateVisitDate;

    /**
     * 构造方法
     * @param name 顾客姓名
     */
    public Customer(String name) {
        this.name = name;
        this.arrivalTimes = 0;
    }

    /**
     * 打印顾客信息
     * @return 顾客信息
     */
    @Override
    public String toString(){
        return String.format( " %s %d %tY %tm %td ", name, arrivalTimes, lateVisitDate, lateVisitDate, lateVisitDate);
    }

    public LocalDate getLateVisitDate() {
        return lateVisitDate;
    }

    /**
     * 更新顾客的来点次数
     * @param arrivalTimes 到店次数
     */
    public void updateArrivalTimes(int arrivalTimes){
        this.arrivalTimes += arrivalTimes;
    }

    /**
     * 更新顾客的最新到店日期
     * @param lateVisitDate 最新到店日期
     */
    public void setLateVisitTime(LocalDate lateVisitDate) {
        this.lateVisitDate = lateVisitDate;
    }
}
