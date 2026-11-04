package com.petstore.shop;

import java.time.LocalDate;

/**
 * 宠物店自定营业日（不读取真实系统时间）。
 * <p>
 * 每完成一次“开业→歇业”营业日 +1 天。
 *
 * @author pet-store
 */
public class ShopDate {

    private LocalDate currentDate;

    public ShopDate(LocalDate startDate) {
        this.currentDate = startDate;
    }

    public LocalDate getDate() {
        return currentDate;
    }

    /**
     * 进入下一个营业日。
     */
    public void nextDay() {
        currentDate = currentDate.plusDays(1);
    }

    @Override
    public String toString() {
        return "营业日: " + currentDate;
    }
}
