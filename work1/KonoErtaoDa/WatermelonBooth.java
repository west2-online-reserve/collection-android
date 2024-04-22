package Practice;

public class WatermelonBooth {
    private long id; // 摊号
    private String name; // 摊主姓名
    private int total; // 在售西瓜数
    private boolean isClosed; // 是否休摊整改

    // 构造方法
    public WatermelonBooth(long id, String name, int total, boolean isClosed) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.isClosed = isClosed;
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

    public boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    // 重写的 toString() 方法
    @Override
    public String toString() {
        return String.format("摊号: %d, 摊主姓名: %s, 在售西瓜数: %d, 是否休摊整改: %b", id, name, total, isClosed);
    }

    // 静态方法 purchase
    public static void purchase(WatermelonBooth seller, int buyAmount) {
        if (buyAmount <= 0) {
            System.out.println("购买失败：购买的西瓜数必须为正数。");
        }
        else if (seller.getIsClosed()) {
            System.out.println("购买失败：商家处于休摊整改状态。");
        }
        else if (buyAmount > seller.getTotal()) {
            System.out.println("购买失败：购买西瓜数大于在售西瓜数。");
        }
        else {
            seller.setTotal(seller.getTotal() - buyAmount);
            System.out.println("购买成功，已购买西瓜数：" + buyAmount);
        }
    }

    // 实例方法 restock
    public void restock(int stockAmount) {
        if (stockAmount > 200) {
            System.out.println("进货失败：单次进货量不能超过200。");
            return;
        }
        this.total += stockAmount;
        System.out.println("进货成功，当前在售西瓜数：" + this.total);
    }

    // 静态方法 closeBooths
    public static void closeBooths(WatermelonBooth[] booths) {
        for (WatermelonBooth booth : booths) {
            if (!booth.getIsClosed()) {
                booth.setIsClosed(true);
                System.out.println("已将摊位休业整改：" + booth);
            }
        }
    }
}


class test {
    public static void main(String[] args) {
        // 创建几个 WatermelonBooth 实例
        WatermelonBooth booth1 = new WatermelonBooth(101, "老王", 50, false);
        WatermelonBooth booth2 = new WatermelonBooth(102, "老李", 80, false);
        WatermelonBooth booth3 = new WatermelonBooth(103, "老张", 30, true);

        // 测试 getter 和 setter
        System.out.println("booth1摊号（原始): " + booth1.getId());
        booth1.setId(100);
        System.out.println("booth1摊号（更新后): " + booth1.getId());

        System.out.println("booth1摊主姓名（原始): " + booth1.getName());
        booth1.setName("老李");
        System.out.println("booth1摊主姓名（更新后): " + booth1.getName());

        System.out.println("booth1在售西瓜数（原始): " + booth1.getTotal());
        booth1.setTotal(60);
        System.out.println("booth1在售西瓜数（更新后): " + booth1.getTotal());

        System.out.println("booth1是否休摊整改（原始): " + booth1.getIsClosed());
        booth1.setIsClosed(true);
        System.out.println("booth1是否休摊整改（更新后): " + booth1.getIsClosed());
        booth1.setIsClosed(false);

        // 测试 toString 方法
        System.out.println("booth1信息: " + booth1);

        // 测试 purchase 方法
        WatermelonBooth.purchase(booth1, 10);
        WatermelonBooth.purchase(booth3, 5);
        WatermelonBooth.purchase(booth1, -5);
        WatermelonBooth.purchase(booth1, 100);
        WatermelonBooth.purchase(booth1, 40);

        // 测试 restock 方法
        booth2.restock(150);
        booth2.restock(250);

        // 输出所有摊位信息
        System.out.println("所有摊位信息：");
        System.out.println(booth1);
        System.out.println(booth2);
        System.out.println(booth3);

        // 测试 closeBooths 方法
        WatermelonBooth.closeBooths(new WatermelonBooth[]{booth1, booth2, booth3});

        // 再次输出所有摊位信息以确认关闭操作
        System.out.println("摊位关闭后的信息：");
        System.out.println(booth1);
        System.out.println(booth2);
        System.out.println(booth3);
    }
}