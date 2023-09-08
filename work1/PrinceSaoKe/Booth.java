package work1.PrinceSaoKe;

public class Booth {
    private long id;
    private String name;
    private int tota;
    private Boolean isClosed;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setTota(int tota) {
        this.tota = tota;
    }

    public long getTota() {
        return this.tota;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public Boolean getIsClosed() {
        return this.isClosed;
    }

    public String toString() {
        return String.format("id: %d, name: %s, tota: %d, isClosed: %b", this.id, this.name, this.tota, this.isClosed);
    }

    public Booth(long id, String name, int tota, boolean isClosed) {
        this.id = id;
        this.name = name;
        this.tota = tota;
        this.isClosed = isClosed;
    }

    public Boolean sale(int number) {
        if (number <= 0) {
            System.out.println("卖西瓜的数量必须是正数！");
        }

        if (isClosed) {
            System.out.println("商家处于休摊整改状态！");
            return false;
        } else if (tota < number) {
            System.out.println("购买西瓜数大于在售西瓜数！");
            return false;
        } else {
            // tota -= number;
            return true;
        }
    }

    public static Boolean purchase(Booth booth, int number) {
        if (number <= 0) {
            System.out.println("购买西瓜的数量必须是正数！");
            return false;
        }
        if (booth.sale(number)) {
            System.out.println("交易成功！");
            return true;
        } else {
            System.out.println("交易失败！");
            return false;
        }
    }

    public Boolean restock(int number) {
        if (number <= 0) {
            System.out.println("进货量必须是正数！");
            return false;
        } else if (number > 200) {
            System.out.println("单次进货量不能超过200！");
            return false;
        }

        tota += number;
        System.out.println("进货成功！");
        return true;
    }

    public static void closeBooths(Booth[] booths) {
        for (Booth booth : booths) {
            booth.setIsClosed(true);
            System.out.println(booth.toString());
        }
    }
}