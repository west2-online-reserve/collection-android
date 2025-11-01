package com.example.animalshop;
import java.time.LocalDate;
import java.util.Objects;

/**
 * 顾客类
 */
public class Customer {
    private String name;
    private int visitCount;
    private LocalDate latestVisitDate;

    public Customer(String name) {
        this.name = name;
        this.visitCount = 1;
        this.latestVisitDate = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public LocalDate getLatestVisitDate() {
        return latestVisitDate;
    }

    public void setLatestVisitDate(LocalDate latestVisitDate) {
        this.latestVisitDate = latestVisitDate;
    }

    /**
     * 重写toString方法
     */
    @Override
    public String toString() {
        return String.format("顾客 [姓名: %s, 到店次数: %d, 最新到店时间: %s]",
                name, visitCount, latestVisitDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name);
    }
}
