package com.petstore.animal;

/**
 * 动物抽象类。
 *
 * @author pet-store
 */
public abstract class Animal {

    /** 动物个体名字 */
    private final String name;

    /** 年龄（岁） */
    private final int age;

    /** 性别 */
    private final Gender gender;

    /** 售价（元） */
    private final double price;

    /**
     * 全参构造方法。
     *
     * @param name   动物个体名字
     * @param age    年龄
     * @param gender 性别
     * @param price  售价
     */
    protected Animal(String name, int age, Gender gender, double price) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public double getPrice() {
        return price;
    }

    /**
     * 动物的中文品种名。
     *
     * @return 品种名
     */
    public abstract String getSpecies();

    /**
     * 抽象 toString，由子类实现。
     *
     * @return 动物信息字符串
     */
    @Override
    public abstract String toString();
}
