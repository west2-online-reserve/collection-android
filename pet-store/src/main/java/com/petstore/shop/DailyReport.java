package com.petstore.shop;

import com.petstore.customer.Customer;

import java.util.List;

/**
 * 当日营业统计（歇业结算用）。
 *
 * @author pet-store
 */
public class DailyReport {

    private final String date;
    private final List<Customer> visitors;
    private final double sales;

    public DailyReport(String date, List<Customer> visitors, double sales, double purchaseCost) {
        this.date = date;
        this.visitors = visitors;
        this.sales = sales;
    }

    public String getDate() {
        return date;
    }

    public List<Customer> getVisitors() {
        return visitors;
    }

    public double getSales() {
        return sales;
    }


    /**
     * 净利润 = 卖出总额 - 买入花费。
     *
     * @return 净利润
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== 歇业结算（").append(date).append("）=====\n");
        sb.append("今日光顾顾客（").append(visitors.size()).append("位）：\n");
        if (visitors.isEmpty()) {
            sb.append("  （无）\n");
        } else {
            for (Customer c : visitors) {
                //增强for，类名+名+集合（限collection，即list和set）
                sb.append("  - ").append(c.getName())
                        .append("（到店").append(c.getVisitCount()).append("次）\n");
            }
        }
        sb.append(String.format("成交金额：¥%.2f%n", sales));
        sb.append("===================================");
        return sb.toString();
    }
}
