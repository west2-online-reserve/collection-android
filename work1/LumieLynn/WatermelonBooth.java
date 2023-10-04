package LumieLynn;

public class WatermelonBooth {
	private long id;
    private String name;
    private int total;
    private boolean isClosed;

    public WatermelonBooth(long id,String name,int total,boolean isClosed) {
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

    public String toString() {
        return "ID:"+ getId() + " " + "Name:" + getName() + " " + "Total:" + getTotal() + " " + "IsClosed:" + getIsClosed();
    }

    public static void purchase(WatermelonBooth watermelonBooth,int num) {
        if (num<=0) {
            System.out.println("You cannot buy watermelon with a negative quantity.");
        }
        else if(watermelonBooth.isClosed) {
            System.out.println(watermelonBooth.name + " is closed!");
        }
        else if(num > watermelonBooth.total) {
            System.out.println("The number of watermelons you bought exceeds the number of watermelons available in the store.");
        }
        else {
            System.out.println(watermelonBooth.name + " sold " + num + " watermelon(s)!");
            watermelonBooth.total-=num;
        }
    }

    public void restock(int add) {
        if (add > 200) {
            System.out.println("The stocking up amount should't exceed 200.");
        }
        if (add < 0) {
            System.out.println("Hey, you're stocking up...");
        }
        else {
            total+=add;
            System.out.println(name + "'ve stock up " + add + " watermelon(s).");
        }
    }

    public static void closeBooths(WatermelonBooth[] booths){
        for (WatermelonBooth booth:booths) {
            if (booth.getIsClosed()){
                System.out.println(booth.toString());
            }
            else {
                booth.isClosed = true;
            }
        }
    }
}
