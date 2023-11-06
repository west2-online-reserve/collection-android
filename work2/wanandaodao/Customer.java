package com.wanandaodao.zoo;

import java.time.LocalDate;

/**
 * @author 晚安叨叨
 */
public class Customer {
    public String name;
    public int times;
    public LocalDate latestTime;
    public Animal animal;
    public Customer(String name, int times, LocalDate latestTime,Animal animal) {
        this.name = name;
        this.times = times;
        this.latestTime = latestTime;
        this.animal=animal;
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

    public void setTimes(int times) {
        this.times = times;
    }

    public LocalDate getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(LocalDate latestTime) {
        this.latestTime = latestTime;
    }

    @Override
    public String toString() {
        return name+" 到店次数 : "+times+" 最新到店时间为 : "+latestTime.getYear()+'.'+latestTime.getMonth()+'.'+latestTime.getDayOfMonth();
    }
}
