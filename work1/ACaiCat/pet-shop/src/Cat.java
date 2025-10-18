public class Cat extends Animal {
    protected boolean isHissing;

    public Cat(String name, int age, boolean isMale, boolean isHissing) {
        super(name, age, isMale, 200.0);
        this.isHissing = isHissing;
    }

    @Override
    public String toString() {
        return String.format("Cat{name=%s,age=%d,isMale=%b,price=%.2f,isHissing=%b}",
                this.name, this.age, this.isMale, this.price, this.isHissing);
    }
}
