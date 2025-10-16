public class Dog extends Animal {

    protected boolean isVaccineInjected;

    public Dog(String name, int age, boolean isMale, double price, boolean isVaccineInjected) {
        super(name, age, isMale, price);
        this.isVaccineInjected = isVaccineInjected;
    }

    @Override
    public String toString() {
        return String.format("Dog{name=%s,age=%d,isMale=%b,price=%.2f,isVaccineInjected=%b}",
                this.name, this.age, this.isMale, this.price, this.isVaccineInjected);
    }
}
