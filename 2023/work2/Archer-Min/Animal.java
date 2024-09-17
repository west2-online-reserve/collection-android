public abstract class Animal {
    protected String name;
    protected int age;
    protected String sex;
    protected double priceOut;
    protected double priceIn;

    public double getPriceOut() {
        return priceOut;
    }

    public void setPriceOut(double priceOut) {
        this.priceOut = priceOut;
    }

    public double getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(double priceIn) {
        this.priceIn = priceIn;
    }

    public String getName() {
        return name;
    }

    public Animal(String name, int age, String sex, double priceIn, double priceOut) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.priceOut = priceOut;
        this.priceIn = priceIn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public abstract String toString();

}
