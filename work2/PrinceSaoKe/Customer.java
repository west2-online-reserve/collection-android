package work2.PrinceSaoKe;

import java.time.LocalDate;

public class Customer {

    private String name;
    private int visitCount = 0;
    private LocalDate lastestVisitDate = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public LocalDate getLastestVisitDate() {
        return lastestVisitDate;
    }

    public void setLastestVisitDate(LocalDate lastestVisitDate) {
        this.lastestVisitDate = lastestVisitDate;
    }

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "顾客，姓名：" + name + "，到店次数：" + visitCount + "，最新到店时间：" + lastestVisitDate;
    }

}
