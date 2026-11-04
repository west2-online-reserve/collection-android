package example.pet.animal.impl;

import example.pet.animal.Animal;

public class Cat extends Animal {

    public Cat(String name, int age, Gender gender) {
        super(name, age, gender, 200);
    }

    @Override
    public String toString() {
        return name;
    }

}
