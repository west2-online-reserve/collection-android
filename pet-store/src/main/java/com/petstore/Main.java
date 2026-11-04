package com.petstore;

import com.petstore.shop.MyAnimalShop;
import com.petstore.ui.PetStoreFrame;

import javax.swing.SwingUtilities;

/**
 * 宠物店 GUI 启动入口。
 *
 * @author pet-store
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyAnimalShop shop = new MyAnimalShop(MyAnimalShop.DEFAULT_BALANCE);
            PetStoreFrame frame = new PetStoreFrame(shop);
            frame.setVisible(true);
        });
    }
}
