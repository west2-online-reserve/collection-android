public class watermelon {

    private long id;
    private String name;
    private int total;
    private boolean isClosed;


    public watermelon(long id, String name, int total, boolean isClosed) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.isClosed = isClosed;
    }

    public watermelon() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    // toString
    @Override
    public String toString() {
        return String.format("摊号: %d, 摊主姓名: %s, 在售西瓜数: %d, 是否休摊整改: %b",
                id, name, total, isClosed);
    }


    public static void purchase(watermelon booth, int amount) {
        if ((amount <= 0) || booth.isClosed() || (amount > booth.getTotal())) {
            System.out.println("交易失败");
        } else {
            booth.setTotal(booth.getTotal() - amount);
            System.out.println("交易成功");
        }
    }


    public void restock(int amount) {
        if (amount > 200 || amount <= 0) {
            System.out.println("进货失败，单次进货量需在1到200之间,请再次进货");
        } else {
            this.total += amount;
        }
    }

    // 静态方法
    public static void closeBooths(watermelon[] booths) {
        for (watermelon booth : booths) {
            if (!booth.isClosed()) {
                booth.setClosed(true);
            } else {
                System.out.println(booth.toString());
            }
        }
    }

}
 class watermelontest {
    public static void main(String[] args) {

        watermelon  booth1 = new watermelon (1, "小张", 100, false);
        watermelon  booth2 = new watermelon (2, "小美", 50, false);


        System.out.println("原始摊位信息");
        System.out.println(booth1);
        System.out.println(booth2);


        System.out.println("从摊位1购买20个西瓜");
        watermelon .purchase(booth1, 20);
        System.out.println(booth1);

        System.out.println("为摊位2进货120个西瓜");
        booth2.restock(120);
        System.out.println(booth2);


        System.out.println("关闭所有摊位");
        watermelon [] booths = {booth1, booth2};
        watermelon .closeBooths(booths);
        System.out.println(booth1);
        System.out.println(booth2);
    }
}



