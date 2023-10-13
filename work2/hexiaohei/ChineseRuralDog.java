package work2.hexiaohei;

/**
 * @version 1.0 2023.10.13
 * @author hexiaohei
 */
public class ChineseRuralDog extends Animal {
    private final String sort;

    public ChineseRuralDog(String name, int age, String sex, double price, boolean isVaccineInjected){
        this.sort = "中华田园犬";
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.price = price;
        this.cost = 100;
        this.isVaccineInjected = isVaccineInjected;
    }

    public String toString(){
        return String.format(" %n%s %s %d %s %f %f %b",sort, name, age, sex, price, cost, isVaccineInjected);
    }
}
