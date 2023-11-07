package com.wanandaodao.zoo;

import java.time.LocalDate;

/**
 * @author 晚安叨叨
 */
public class Customer {
    private String name;
    private int times;
    private LocalDate latestTime;

    public Customer(String name, int times, LocalDate latestTime) {
        this.name = name;
        this.times = times;
        this.latestTime = latestTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimes() {
        return times;
    }

    public void autoincrement() {
        this.times++;
    }

    public LocalDate getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(LocalDate latestTime) {
        this.latestTime = latestTime;
    }

    @Override
    public String toString() {
        return name + " 到店次数 : " + times + " 最新到店时间为 : " + latestTime.getYear() + '.' + latestTime.getMonth() + '.' + latestTime.getDayOfMonth();
    }
}
