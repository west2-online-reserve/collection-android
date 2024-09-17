public abstract class Animal {
    protected String name;
    protected int age;
    protected String gender;
    protected double price;
    protected  double cost;

    // 构造函数
    public Animal() {
    }

    public Animal(String name, int age, String gender, double price, double cost) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.price = price;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getPrice() {
        return price;
    }
    public double getCost() {return cost;}

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCost(double cost) {this.cost = cost;}

    // 抽象方法
    public abstract String toString();
}
