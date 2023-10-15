package com.hexiaohei.work02.pet;

/**
 * @version 1.0 2023.10.13
 * @author hexiaohei
 */
public abstract class Animal {
    protected String name;
    protected int age;
    protected String sex;
    protected double cost;
    protected double price;
    protected boolean isVaccineInjected;

    public Animal(String name, int age, String sex, double cost, double price, boolean isVaccineInjected) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.cost = cost;
        this.price = price;
        this.isVaccineInjected = isVaccineInjected;
    }


    public abstract String toString();
}
