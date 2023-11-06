package com.wanandaodao.zoo;

/**
 * @author 晚安叨叨
 */
public class ChineseRuralDog extends Animal{
    private boolean isVaccineInjected;

    public boolean isVaccineInjected() {
        return isVaccineInjected;
    }

    public void setVaccineInjected(boolean vaccineInjected) {
        isVaccineInjected = vaccineInjected;
    }

    public ChineseRuralDog(String name, int age, String sex, boolean isVaccineInjected) {
        super(name, age, sex, 100);
        this.isVaccineInjected = isVaccineInjected;
    }

    @Override
    public String toString() {
        return "ChineseRuralDog{" +
                "isVaccineInjected=" + isVaccineInjected +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
