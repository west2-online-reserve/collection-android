public abstract class Animal {
    protected String name;
    protected int age;
    protected boolean isMale;
    protected double price;
    public Animal(String name, int age, boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }
    public double getPrice(){
        return 0;
    };
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Animal [name=");
        builder.append(name);
        builder.append(", age=");
        builder.append(age);
        builder.append(", isMale=");
        builder.append(isMale);
        builder.append(", price=");
        builder.append(price);
        builder.append("]");
        return builder.toString();
    }
}
