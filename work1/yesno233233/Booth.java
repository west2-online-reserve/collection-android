package Watermelon;
public class Booth {

    //属性
    private long id;
    private String name;
    private int total;
    private boolean isClosed;

    public Booth(long id, String name, int total, boolean isClosed) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.isClosed = isClosed;
    }

    //静态方法：购买purchase
    public static void purchase(int purchaseNum, int total, boolean isClosed) {
        if (purchaseNum > total || purchaseNum <= 0 || isClosed ) {
            System.out.println("购买失败。"
                    + "购买的西瓜数为" + purchaseNum
                    + "在售西瓜数为" + total
                    + "是否关门状态：" + isClosed
                    + "请确保购买的西瓜数必须为正数；商家不能处于休摊整改状态；购买西瓜数不能大于在售西瓜数。");
            return;
        }
        total = total - purchaseNum;
        System.out.println("购买成功"
                + "成功购买的西瓜数为" + purchaseNum
                + "摊位剩余西瓜数为" + total);
    }


    //get和set
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

    public void setClosed(boolean closed) {
        isClosed = closed;
    }


    //实例方法：进货restock
    public void restock(int restockNum) {
        if (restockNum <= 0 || restockNum > 200) {
            System.out.println("进货失败" +
                    "你的进货量为" + restockNum
                    + "你的进货物应该在1~200之间");
            return;
        }
        total=total+restockNum;
        System.out.println("成功进货"+restockNum+"个西瓜"
                            +"现在摊位共有"+total+"个西瓜在售");
    }

    //静态方法，关店closeBooths
    public static void closeBooths(Booth[] booths){
        for (Booth booth : booths) {
            if (!booth.isClosed()) {
                booth.setClosed(true);
                System.out.println("摊位已休业整改：" + booth.toString());
            }
        }
    }
    @Override
    public String toString() {
        return "摊位信息：" +
                "摊号=" + id +
                ", 摊主姓名：'" + name  +
                ", 在售西瓜数：" + total +
                ", 是否休摊整改：" + isClosed;
    }
}