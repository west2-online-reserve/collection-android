public interface AnimalShop {
    void Buyin(Animal animal) throws Exception;

    void EntertainCustomer(Customer customer,Animal animal) throws Exception;
    void CloseShop();
    void OpenShop();
    void AddInitialAnimal(Animal animal) throws Exception;
}
