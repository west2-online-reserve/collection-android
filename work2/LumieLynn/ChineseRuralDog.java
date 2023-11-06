

public class ChineseRuralDog extends Animal {
    private boolean isVaccineInjected;

    public ChineseRuralDog(int id, String name, int age, boolean isMale, boolean isVaccineInjected) {
        super(id, name, age, isMale);
        this.isVaccineInjected = isVaccineInjected;
    }

    public boolean getIsVaccineInjected() {
        return isVaccineInjected;
    }

    public void setIsVaccineInjected(boolean isVaccineInjected) {
        this.isVaccineInjected = isVaccineInjected;
    }

    @Override
    public double getPrice() {
        return 200;
    }

    @Override
    public String toString() {
        StringBuilder RuralDogString = new StringBuilder();
        RuralDogString.append("ChineseRuralDog. ID:");
        RuralDogString.append(this.id);
        RuralDogString.append("\t Name:");
        RuralDogString.append(this.name);
        RuralDogString.append("\t Age:");
        RuralDogString.append(this.age);
        RuralDogString.append("\t isMale:");
        RuralDogString.append(this.isMale);
        RuralDogString.append("\t Price:");
        RuralDogString.append(getPrice());
        RuralDogString.append("\t isVaccineInjected:");
        RuralDogString.append(this.isVaccineInjected);
        return RuralDogString.toString();
    }
}
