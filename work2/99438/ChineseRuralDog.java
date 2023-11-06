public class ChineseRuralDog extends Animal {
    // 打点疫苗吧
    private boolean isVaccineInjected;
    // 构造函数
    public ChineseRuralDog(String name, int age, String gender, double price, double cost, boolean isVaccineInjected) {
        super(name, age, gender, price,cost);
        this.isVaccineInjected = isVaccineInjected;
    }

    @Override
    public String toString() {
        return "Chinese Rural Dog: " + name + "\n"
                +"Age: " + age + "\n"
                +"Gender: " + gender + "\n"
                +"IsVaccineInjected: "+ isVaccineInjected;
    }
}
