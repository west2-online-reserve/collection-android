/**
 * @Author：realzhenikun
 * @Project：PetShop
 * @Date：2023/11/6
 * @Filename：AnimalShop
 */
public interface AnimalShop {
    public void buyNewAnimal(AbstractAnimal animal);

    public void entertainCustomers(Customer customer);

    public void closeShop();

    public void openShop();
}
