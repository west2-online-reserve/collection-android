public class Cat extends Animal{
    public Cat(String name, int age, boolean isMale) {
        super(name, age, isMale);
    }
    @Override
    public double getPrice() {
        return 200;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Cat [name=");
        builder.append(name);
        builder.append(", age=");
        builder.append(age);
        builder.append(", isMale=");
        builder.append(isMale);
        builder.append(", price=");
        builder.append(getPrice());
        builder.append("]");
        return builder.toString();
    }
}
