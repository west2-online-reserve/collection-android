package com.wanandaodao.zoo;

/**
 * @author 晚安叨叨
 */
public interface AnimalShop {
    void buyNewAnimal(Animal animal);

    void treatCustomer(Customer cus, Animal animal);

    void goOutOfBusiness();
}
