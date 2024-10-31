/**
 * @Author：realzhenikun
 * @Project：PetShop
 * @Date：2023/11/6
 * @Filename：AbstractAnimal
 */
public abstract class AbstractAnimal {
    protected String animalName;
    protected int age;
    protected String sex;
    protected double price;

    public AbstractAnimal(String animalName, int age, String sex, double price) {
        this.animalName = animalName;
        this.age = age;
        this.sex = sex;
        this.price = price;
    }

    public String getAnimalName() {
        return animalName;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public double getPrice() {
        return price;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String toString();
}
