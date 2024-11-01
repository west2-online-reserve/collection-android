public class ChineseRuralDog extends Animal{
    public boolean isVaccineInjected;
    public ChineseRuralDog(String name, int age, boolean isMale, boolean isVaccineInjected) {
        super(name, age, isMale);
        this.isVaccineInjected = isVaccineInjected;
    }
    @Override
    public double getPrice() {
        return 100;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ChineseRuralDog [name=");
        builder.append(name);
        builder.append(", age=");
        builder.append(age);
        builder.append(", isMale=");
        builder.append(isMale);
        builder.append(", price=");
        builder.append(getPrice());
        builder.append(", isVaccineInjected=");
        builder.append(isVaccineInjected);
        builder.append("]");
        return builder.toString();
    }
}
