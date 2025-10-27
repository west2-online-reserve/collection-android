package com.example.animalshop;
/**
 * 动物抽象类
 */
public abstract class Animal {
    protected String name;
    protected int age;
    protected String gender;
    protected double price;

    public Animal(String name, int age, String gender, double price) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.price = price;
    }

    // Get方法
    public String getName() {
        return name;
    }

    public int getAge() {return age;}

    public String getGender() {
        return gender;
    }

    public double getPrice() {
        return price;
    }

    /**
     * 抽象toString方法
     */
    @Override
    public abstract String toString();

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        Animal animal = (Animal) o;
//        return age == animal.age
//                && Double.compare(animal.price, price) == 0
//                && Objects.equals(name, animal.name)
//                && Objects.equals(gender, animal.gender);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age, gender, price);
//    }
}
