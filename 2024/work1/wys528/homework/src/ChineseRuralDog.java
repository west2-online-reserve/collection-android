public class ChineseRuralDog extends Animal {
    private boolean isVaccineInjected;

    public ChineseRuralDog(String name, int age, String gender, boolean isVaccineInjected) {
        super(name, age, gender, 100.0); // 价格100元
        this.isVaccineInjected = isVaccineInjected;
    }

    @Override
    public String toString() {
        return "中华田园犬 [name=" + name + ", age=" + age + ", gender=" + gender +
                ", isVaccineInjected=" + isVaccineInjected + ", price=" + price + "]";
    }
}
