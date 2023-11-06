package com.hexiaohei.work02.pet;

/**
 * @version 1.0 2023.10.13
 * @author hexiaohei
 */
public class Hamster extends Animal {
    private final String sort;
    
    public Hamster(String name, int age, String sex, double cost, double price, boolean isVaccineInjected){
        super(name, age, sex, cost, price, isVaccineInjected);
        this.sort = "仓鼠";
    }
    
    @Override
    public String toString(){
        return String.format(" %n%s %s %d %s %f %b",sort, name, age, sex, price, isVaccineInjected);
    }
}
