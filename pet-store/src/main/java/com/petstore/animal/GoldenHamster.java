package com.petstore.animal;

/**
 * 金丝熊仓鼠。
 * <p>
 * 固定售价 55 元。
 *
 * @author pet-store
 */
public class GoldenHamster extends Animal {

    /** 售价（元） */
    public static final double PRICE = 55.0;

    public GoldenHamster(String name, int age, Gender gender) {
        super(name, age, gender, PRICE);
    }

    @Override
    public String getSpecies() {
        return "金丝熊仓鼠";
    }

    @Override
    public String toString() {
        return String.format("[金丝熊仓鼠] %s(%s, %d岁, ¥%.0f)",
                getName(), getGender(), getAge(), getPrice());
    }
}
