package com.petstore.shop;

import com.petstore.animal.Animal;
import com.petstore.customer.Customer;
import com.petstore.exception.AnimalNotFoundException;
import com.petstore.exception.InsufficientBalanceException;

/**
 * 宠物店接口。
 *
 * @author pet-store
 */
public interface AnimalShop {

    /**
     * 买入新动物。
     *
     * @param animal 要买入的动物
     * @throws InsufficientBalanceException 余额不足以支付进价时抛出
     */
    void buyAnimal(Animal animal) throws InsufficientBalanceException;

    /**
     * 招待客户。
     *
     * @param customer 客户
     * @throws AnimalNotFoundException 店内没有动物可卖时抛出
     */
    void entertainCustomer(Customer customer) throws AnimalNotFoundException;

    /**
     * 歇业。
     *
     * @return 当日营业统计
     */
    DailyReport close();
}
