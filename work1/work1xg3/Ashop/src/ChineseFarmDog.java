// ChineseFarmDog.java
public class ChineseFarmDog extends Animal {
    private static final double PRICE_WITH_VACCINE = 200.0;
    private static final double PRICE_WITHOUT_VACCINE = 100.0;
    private boolean hasRabiesVaccine;

    public ChineseFarmDog(String name, int age, String gender, boolean hasRabiesVaccine) {
        super(name, age, gender);
        this.hasRabiesVaccine = hasRabiesVaccine;
    }

    @Override
    public double getPrice() {
        return hasRabiesVaccine ? PRICE_WITH_VACCINE : PRICE_WITHOUT_VACCINE;
    }

    @Override
    public String toString() {
        return "ChineseFarmDog{" +
               "name='" + getName() + '\'' +
               ", age=" + getAge() +
               ", gender='" + getGender() + '\'' +
               ", hasRabiesVaccine=" + hasRabiesVaccine +
               '}';
    }
}
