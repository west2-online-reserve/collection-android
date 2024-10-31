public class MelonBooth {
    private long id;
    private String name;
    private int total;
    private boolean isClosed;

    public MelonBooth(long id, String name, int total, boolean isClosed) {
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

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    @Override
    public String toString() {
        return String.format(
                " id: %d%n name: %s%n total: %d%n isClosed: %b%n",
                this.id, this.name, this.total, this.isClosed);
    }

    public static void purchase(MelonBooth melonBooth,int num){
        if (num<0) {
            System.out.println("购买的西瓜数必须为正数！");
        }else if (melonBooth.isClosed) {
            System.out.println(melonBooth.name+"处于休摊整改状态,购买失败！");
        } else if (num> melonBooth.total) {
            System.out.println("购买西瓜数大于在售西瓜数！");
        } else {
            System.out.println(melonBooth.name+"售出" + num + "个西瓜");
            melonBooth.total-=num;
        }
    }

    public void restock(int add){
        if(add>200){
            System.out.println("进货失败，单次进货量超过200！");
        }else{
            total+=add;
            System.out.println(name+"已进货"+add+"个西瓜");
        }
    }

    public static void closeBooths(MelonBooth[] melonBooths){
        System.out.println("已休业整改摊位：");
        for (MelonBooth booth:melonBooths) {
            if(booth.isClosed) {
                System.out.println(booth.toString());
            }else {
                booth.isClosed = true;
            }
        }
    }
}
