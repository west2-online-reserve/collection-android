package com.petstore.customer;

import java.time.LocalDate;

/**
 * 顾客类。
 *
 * @author pet-store
 */
public class Customer {

    /** 顾客名字 */
    private final String name;

    /** 到店次数 */
    private int visitCount;

    /** 最新到店时间 */
    private LocalDate latestVisitDate;

    /**
     * 构造方法。
     *
     * @param name            顾客名字
     * @param visitCount      到店次数
     * @param latestVisitDate 最新到店时间
     */
    public Customer(String name, int visitCount, LocalDate latestVisitDate) {
        this.name = name;
        this.visitCount = visitCount;
        this.latestVisitDate = latestVisitDate;
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

    /**
     * 记录一次到店：到店次数 +1，更新最新到店日期。
     *
     * @param date 到店日期
     */
    public void visit(LocalDate date) {
        //locadate是类型，date是名字
        this.visitCount++;
        this.latestVisitDate = date;
    }

    @Override
    public String toString() {
        return String.format("顾客{姓名=%s, 到店次数=%d, 最新到店=%s}",
                name, visitCount,
                latestVisitDate == null ? "无" : latestVisitDate);
        //条件判断赋值
        //条件判断为latestVisitDate是否等于null
        //是则显示无，不是则显示latestVisitDate
    }
}
