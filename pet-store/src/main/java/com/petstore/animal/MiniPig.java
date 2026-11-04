package com.petstore.animal;

/**
 * 小香猪。
 * <p>
 * 固定售价 175 元。
 *
 * @author pet-store
 */
public class MiniPig extends Animal {

    /** 售价（元） */
    public static final double PRICE = 175.0;

    public MiniPig(String name, int age, Gender gender) {
        super(name, age, gender, PRICE);
    }

    @Override
    public String getSpecies() {
        return "小香猪";
    }

    @Override
    public String toString() {
        return String.format("[小香猪] %s(%s, %d岁, ¥%.0f)",
                getName(), getGender(), getAge(), getPrice());
    }
}
