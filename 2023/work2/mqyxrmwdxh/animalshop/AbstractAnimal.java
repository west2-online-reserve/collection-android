package work2.mqyxrmwdxh.animalshop;

/**
 * @author 32867
 */
public abstract class AbstractAnimal {
    protected String name;
    protected int age;
    protected double price;
    protected double weight;
    protected SexEnum sex;

    AbstractAnimal(String name, int age, double price, double weight, SexEnum sex) {
        this.age = age;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public abstract String toString();
}
