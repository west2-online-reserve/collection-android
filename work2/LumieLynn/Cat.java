

public class Cat extends Animal {
    public Cat(int id, String name, int age, boolean isMale) {
        super(id, name, age, isMale);
    }

    @Override
    public double getPrice() {
        return 200;
    }

    @Override
    public String toString() {
        StringBuilder CatString = new StringBuilder();
        CatString.append("Cat. ID:");
        CatString.append(this.id);
        CatString.append("\t Name:");
        CatString.append(this.name);
        CatString.append("\t Age:");
        CatString.append(this.age);
        CatString.append("\t isMale:");
        CatString.append(this.isMale);
        CatString.append("\t Price:");
        CatString.append(getPrice());
        return CatString.toString();
    }
}