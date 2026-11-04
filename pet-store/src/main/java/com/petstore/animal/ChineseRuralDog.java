package com.petstore.animal;

/**
 * 中华田园犬。
 * <p>
 * 固定售价 100 元，统一已注射狂犬病疫苗。
 *
 * @author pet-store
 */
public class ChineseRuralDog extends Animal {

    /** 售价（元） */
    public static final double PRICE = 100.0;

    /** 是否注射狂犬病疫苗 */
    private final boolean isVaccineInjected;

    public ChineseRuralDog(String name, int age, Gender gender) {
        super(name, age, gender, PRICE);
        this.isVaccineInjected = true;
    }

    public boolean isVaccineInjected() {
        return isVaccineInjected;
    }

    @Override
    public String getSpecies() {
        return "中华田园犬";
    }

    @Override
    public String toString() {
        return String.format("[中华田园犬] %s(%s, %d岁, ¥%.0f, 已狂犬疫苗)",
                getName(), getGender(), getAge(), getPrice());
    }
}
