package petstore;

// 狗，固定售价 100 元

public class ChineseRuralDog extends Animal {
    private boolean isVaccineInjected;

    public ChineseRuralDog(String name, int age, String gender, boolean isVaccineInjected) {
        super(name, age, gender, 100);
        this.isVaccineInjected = isVaccineInjected;
    }

    public boolean isVaccineInjected() {
        return isVaccineInjected;
    }

    @Override
    public String toString() {
        return "中华田园犬{name='" + name + "', age=" + age
                + ", gender='" + gender + "', price=" + price
                + ", isVaccineInjected=" + isVaccineInjected + "}";
    }
}
