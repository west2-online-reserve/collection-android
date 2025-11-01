package com.example.animalshop;

//public class ChineseRuralDog extends Animal{
//    private boolean isVaccineInjected;
//
//    public ChineseRuralDog(String name, int age, String gender, double price, boolean isVaccineInjected) {
//        super(name, age, gender, 100.0);
//        this.isVaccineInjected = isVaccineInjected;
//
//    }
//
//    @Override
//    public String toString() {
//        return String.format("中华田园犬[名字：%s,年龄:%d岁，性别：%s,价格：%。2f,已注射疫苗：%s。"
//                                             ,name,age,gender,price,isVaccineInjected);
//    }
//}
public class ChineseRuralDog extends Animal {
    private boolean isVaccineInjected;

    public ChineseRuralDog(String name, int age, String gender, boolean isVaccineInjected) {
        super(name, age, gender, 100.0);
        this.isVaccineInjected = isVaccineInjected;
    }

    public boolean isVaccineInjected() {
        return isVaccineInjected;
    }

    @Override
    public String toString() {
        return String.format("中华田园犬 [名字: %s, 年龄: %d岁, 性别: %s, 价格: %.2f元, 已注射疫苗: %s]",
                name, age, gender, price, isVaccineInjected ? "是" : "否");
    }
}