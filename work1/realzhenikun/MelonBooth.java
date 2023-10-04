public class MelonBooth {
    //私有变量
    long id;
    String name;
    int total;
    boolean isClosed;

    //方法

    //构造方法
    public MelonBooth(long id, String name, int total, boolean isClosed)
    {
        this.id = id;
        this.name = name;
        this.total = total;
        this.isClosed = isClosed;
    }

    //各变量对应的get方法
    public long getId() { return id; }
    public String getName() { return name; }
    public int getTotal() { return total; }
    public boolean getIsClosed() { return isClosed; }

    //各变量对应的set方法
    public void setId(long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setTotal(int total) { this.total = total; }

    public void setIsClosed(boolean isClosed) { this.isClosed = isClosed; }

    //向目标摊位购买指定数量的西瓜
    public static void purchase(MelonBooth booth, int num)
    {
        if (booth.isClosed)
        {
            System.out.println("购买失败,商家休摊整改中");
        }
        else if (num <= 0)
        {
            System.out.println("购买失败,购买的西瓜数量必须为正数");
        }
        else if (num > booth.total)
        {
            System.out.println("购买失败,购买西瓜数大于在售西瓜数");
        }
        else
        {
            booth.total -= num;
            System.out.printf("交易成功，已成功购买%d个西瓜\n", num);
        }
    }

    //进货
    public void restock(int num)
    {
        if (num > 200)
        {
            System.out.println("进货失败,进货量过多");
        }
        else if (num <= 0)
        {
            System.out.println("进货失败，进货量必须为正数");
        }
        else
        {
            total += num;
            System.out.printf("进货成功，已成功进货%d个西瓜\n", num);
        }
    }

    //让MelonBooth[]中所有未被休业整改的摊位歇业，输出已在休业整改的摊位信息
    public static void closeBooths(MelonBooth[] booths)
    {
        System.out.println("已在休业整改的摊位信息：");
        for (MelonBooth mb: booths)
        {
            if (mb.isClosed)
            {
                System.out.println(mb.toString());
            }
            else
            {
                mb.isClosed = true;
            }
        }
        System.out.println("已让所有未休业的摊位歇业");
    }

    //重写toString()方法
    public String toString()
    {
        return String.format("------------------------\n" +
                "*当前摊号：%d\n" +
                "*摊主姓名：%s\n" +
                "*当前在售西瓜数：%d\n" +
                "*是否休摊整改：%b\n" +
                "------------------------\n", id, name, total, isClosed);
    }
}
