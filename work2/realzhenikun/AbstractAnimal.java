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

    public abstract String toString();
}
