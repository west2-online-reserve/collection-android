public class Dog extends Animal {

    protected boolean vaccineInjected;

    public void injectedVaccine() {
        this.vaccineInjected = true;
    }

    public Dog(String name, int age, boolean isMale, boolean vaccineInjected) {
        super(name, age, isMale, 200.0);
        this.vaccineInjected = vaccineInjected;
    }

    @Override
    public String toString() {
        return String.format("Dog{name=%s,age=%d,isMale=%b,price=%.2f,isVaccineInjected=%b}",
                this.name, this.age, this.male, this.price, this.vaccineInjected);
    }
}
