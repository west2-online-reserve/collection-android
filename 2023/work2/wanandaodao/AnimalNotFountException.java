package com.wanandaodao.zoo;

public class AnimalNotFountException extends RuntimeException{
    public Animal animal;

    public AnimalNotFountException(Animal animal) {
        this.animal = animal;
    }
    public void printError(){
        if(animal instanceof ChineseRuralDog){
            System.out.println("店内暂无您想要购买的中华田园犬");
        }
        else if(animal instanceof Cat){
            System.out.println("店内暂无您想要购买的猫");
        }
    }
}
