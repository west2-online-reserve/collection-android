package com.wanandaodao.code1;
class waterMelon {
    private long ID;//摊号
    private String name;//摊主姓名
    private int solvingTotal;//在售西瓜数
    private boolean isClosed;//是否关门

    public waterMelon(long ID_, String name_, int total, boolean closed) {
        ID = ID_;
        name = name_;
        solvingTotal = total;
        isClosed = closed;
    }

    public static void purchase(waterMelon business, int purchaseNum) {
        if (purchaseNum <= 0) {
            System.out.println("Purchase failed, purchase quantity must be positive");
            return;
        }
        if (business.isClosed) {
            System.out.println("Purchase failed, this stall owner has already closed");
            return;
        }
        int solvingTotal = business.getTotal();//在售西瓜数量
        if (solvingTotal < purchaseNum) {
            System.out.println("Purchase failed. This vendor has fewer watermelons than you need");
            return;
        }
        business.setSolvingTotal(solvingTotal - purchaseNum);
        System.out.println("Purchase successful");
    }

    public static void closeBooths(waterMelon[] booths) {
        int length = booths.length;
        for (int i = 0; i < length; i++) {
            if (!booths[i].getClosed())
                booths[i].setClosed(true);
            else
                booths[i].toString(booths[i]);
        }
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID_) {
        ID = ID_;
    }

    public String getName() {
        return name;
    }

    public void setName(String name_) {
        name = name_;
    }

    public void setSolvingTotal(int total) {
        solvingTotal = total;
    }

    public int getTotal() {
        return solvingTotal;
    }

    public boolean getClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public void toString(waterMelon w) {
        System.out.printf("%-10s %-7d %-7d %s\n", name, ID, solvingTotal, isClosed);
    }

    public void restock(int purchaseQuantity) {
        if (purchaseQuantity > 200) {
            System.out.println("The purchase quantity cannot exceed 200!");
            return;
        }
        solvingTotal += purchaseQuantity;
    }
}
