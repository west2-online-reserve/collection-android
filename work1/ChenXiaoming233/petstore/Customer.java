package petstore;

import java.time.LocalDate;

// 顾客，固定售价0元
// 顾客类，记录顾客信息和到店情况
public class Customer {
    private String name;
    private int visitCount;
    private LocalDate latestVisitDate;

    public Customer(String name) {
        this.name = name;
        this.visitCount = 0;
        this.latestVisitDate = null;
    }

    // 记录一次到店，并更新最近到店日期
    public void visit(LocalDate date) {
        visitCount++;
        latestVisitDate = date;
    }

    public String getName() {
        return name;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public LocalDate getLatestVisitDate() {
        return latestVisitDate;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', visitCount=" + visitCount
                + ", latestVisitDate=" + latestVisitDate + "}";
    }
}
