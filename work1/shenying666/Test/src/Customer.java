import java.time.LocalDate;

public class Customer {
    private String name;
    private int visitCount;
    private LocalDate newVisitDate;
    public Customer(String name) {
        this.name = name;
        this.visitCount = 1;
        this.newVisitDate = LocalDate.now();
    }
    public String getName() {
        return name;
    }
    public int getVisitCount() {
        return visitCount;
    }
    public LocalDate getNewVisitDate() {
        return newVisitDate;
    }
    public void visitShop(){
        visitCount++;
        newVisitDate = LocalDate.now();
    }
    public String toString() {
        return String.format("该顾客信息为：姓名：%s 到店次数：%d 最新到店时间：%s",
                name, visitCount, newVisitDate);
    }
}
