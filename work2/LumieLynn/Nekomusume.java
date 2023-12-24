
public class Nekomusume extends Animal {

    public Nekomusume(int id, String name, int age, boolean isMale) {
        super(id, name, age, isMale);
    }

    @Override
    public double getPrice() {
        return 500;
    }

    @Override
    public String toString() {
        StringBuilder NekoString = new StringBuilder();
        NekoString.append("Nekomusume. ID:");
        NekoString.append(this.id);
        NekoString.append("\t Name:");
        NekoString.append(this.name);
        NekoString.append("\t Age:");
        NekoString.append(this.age);
        NekoString.append("\t isMale:");
        NekoString.append(this.isMale);
        NekoString.append("\t Price:");
        NekoString.append(getPrice());
        return NekoString.toString();
    }
}
