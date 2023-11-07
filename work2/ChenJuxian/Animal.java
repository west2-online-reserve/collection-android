public abstract  class Animal {
    /**
     * @version 1.0 2023.11.4
     * @author cjx
     */
    private String name;  //定义动物名
    private int ages;  //定义动年龄
    private String sex;//定义性别
    private double price;  //定义价格
    private double cost;  //定义价格
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return ages;
    }
    public void setPrice(int name) {
        this.ages = ages;
    }
    public double getCost() {
        return price;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }



    public void Animal(String name,int ages,String sex,double price,double cost){
        this.name=name;
        this.ages=ages;
        this.sex=sex;
        this.cost = cost;
        this.price=price;          //全参构造方法
    }
    public abstract String toString();           //一个抽象的toString方法







}
