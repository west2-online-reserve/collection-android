package mqyxrmwdxh;

public class Booth {
    private long id;
    private String name;
    private int total;
    private boolean isClosed;
    Booth(long id, String name, int total, boolean isClosed) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.isClosed = isClosed;
    }

    public static boolean purchase(Booth booth, int num) {
        if (num <= 0) {
            System.out.println("购买西瓜数目有误，不得小于1");
            return false;
        } else if (num > booth.getTotal()) {
            System.out.println(booth.getName() + "的西瓜没那么多，只有" + booth.getTotal() + "个。少买点！");
            return false;
        } else if (booth.isClosed()) {
            System.out.println("已休摊，下次再来。");
            return false;
        } else {
            booth.setTotal(booth.getTotal() - num);
            System.out.println("购买成功！");
            return true;
        }
    }

    public boolean restock(int num) {
        if (num > 200) {
            System.out.println("进货量不能大于200！");
            return false;
        } else {
            total += num;
            System.out.println("进货成功！当前有" + total + "个西瓜。");
            return true;
        }
    }

    public static void closeBooths(Booth[] booths) {
        for (int i = 0; i < booths.length; i++) {
            if (booths[i].isClosed()) {
                System.out.println(booths[i].toString());
            } else {
                booths[i].setClosed(true);
            }
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setClosed(boolean flag) {
        isClosed = flag;
    }

    public boolean isClosed() {
        return isClosed;
    }

    @Override
    public String toString() {
        return "摊号:" + id + "  摊主姓名:" + name + "  在售西瓜数:" + total + "  是否休摊整改:" + isClosed;
    }
}

