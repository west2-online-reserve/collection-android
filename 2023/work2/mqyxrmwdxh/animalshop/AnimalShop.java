package work2.mqyxrmwdxh.animalshop;

/**
 * @author 32867
 */
public interface AnimalShop {
    public boolean purchaseAnimal(AbstractAnimal animal, double price);

    public void entertainCustomer(Customer customer, AbstractAnimal animal);

    public void closeShop();

    public boolean openShop();

}
