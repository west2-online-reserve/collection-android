package com.petstore.animal;

/**
 * 猫猫。
 * <p>
 * 固定售价 200 元。
 *
 * @author pet-store
 */
public class Cat extends Animal {

    /** 售价（元） */
    public static final double PRICE = 200.0;

    public Cat(String name, int age, Gender gender) {
        super(name, age, gender, PRICE);
    }

    @Override
    public String getSpecies() {
        return "猫猫";
    }

    @Override
    public String toString() {
        return String.format("[猫猫] %s(%s, %d岁, ¥%.0f)",
                getName(), getGender(), getAge(), getPrice());
    }
}
