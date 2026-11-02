package example.pet.animal.impl;

import example.pet.animal.Animal;

public class Dog extends Animal {

    private boolean vaccineInjected;

    public Dog(String name, int age, Gender gender) {
        super(name, age, gender, 100);
    }
    public Dog(String name, int age, Gender gender, boolean vaccineInjected) {
        this(name, age, gender);
        this.vaccineInjected = vaccineInjected;
    }

    public boolean isVaccineInjected() {
        return vaccineInjected;
    }

    public void setVaccineInjected(boolean vaccineInjected) {
        this.vaccineInjected = vaccineInjected;
    }

    @Override
    public String toString() {
        return name;
    }

}
