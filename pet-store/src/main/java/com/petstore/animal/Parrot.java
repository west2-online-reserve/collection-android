package com.petstore.animal;

/**
 * 鹦鹉。
 * <p>
 * 固定售价 90 元。
 *
 * @author pet-store
 */
public class Parrot extends Animal {

    /** 售价（元） */
    public static final double PRICE = 90.0;

    public Parrot(String name, int age, Gender gender) {
        super(name, age, gender, PRICE);
    }

    @Override
    public String getSpecies() {
        return "鹦鹉";
    }

    @Override
    public String toString() {
        return String.format("[鹦鹉] %s(%s, %d岁, ¥%.0f)",
                getName(), getGender(), getAge(), getPrice());
    }
}
