public class Cat extends Animal {
    protected boolean hissing;

    public Cat(String name, int age, boolean isMale, boolean hissing) {
        super(name, age, isMale, 200.0);
        this.hissing = hissing;
    }

    public boolean isHissing() {
        return hissing;
    }

    @Override
    public String toString() {
        return String.format("Cat{name=%s,age=%d,isMale=%b,price=%.2f,isHissing=%b}",
                this.name, this.age, this.male, this.price, this.hissing);
    }
}
