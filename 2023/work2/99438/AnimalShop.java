public interface AnimalShop {
    // 抽象方法——买入小动物
    public abstract void buyNewAnimal(Animal animal, double cost);
    // 抽象方法——招待客户
    public abstract  void treatCustomer(Customer customer, Animal animal);
    // 抽象方法——歇业
    public abstract  void closeShop();
}
