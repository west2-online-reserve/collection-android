import java.time.LocalDate;
public class Customer {

    private String name;
    private int times;
    private LocalDate date;

    public void Customer(String name,int times,LocalDate date){
        this.name=name;
        this.times=times;
        this.date=date;
    }

    @Override
    public String toString() {
        return " 顾客姓名：" + name + " 到店次数：" + times + " 最近到店时间：" + date;
    }
}
