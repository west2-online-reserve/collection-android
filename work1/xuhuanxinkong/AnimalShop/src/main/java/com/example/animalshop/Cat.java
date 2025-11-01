package com.example.animalshop;

public class Cat extends Animal {
    private String color;

    public Cat(String name, int age, String gender, String color) {
        super(name, age, gender, 200.0);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("猫咪 [名字: %s, 年龄: %d岁, 性别: %s, 颜色: %s, 价格: %.2f元]",
                name, age, gender, color, price);
    }
}
