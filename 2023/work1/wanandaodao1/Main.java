package com.wanandaodao.code1;

public class Main {
    public static void main(String[] args) {

        waterMelon w1 = new waterMelon(1234, "张三1", 200, false);
        waterMelon w2 = new waterMelon(1235, "张三2", 200, false);
        waterMelon w3 = new waterMelon(1236, "张三3", 200, true);
        waterMelon w4 = new waterMelon(1237, "张三4", 200, false);
        waterMelon w5 = new waterMelon(1238, "张三5", 200, true);
        waterMelon w6 = new waterMelon(1239, "张三6", 200, false);
        waterMelon w7 = new waterMelon(1240, "张三7", 200, true);

        w1.toString(w1);
        System.out.println(w1.getTotal());
        w1.restock(300);
        w1.restock(100);
        System.out.println(w1.getTotal());

        waterMelon.purchase(w1, 300);
        waterMelon.purchase(w3, 100);
        waterMelon.purchase(w1, 100);
        System.out.println(w1.getTotal());

        waterMelon[] booths = {w1, w2, w3, w4, w5, w6, w7};
        System.out.println("before close");
        waterMelon.closeBooths(booths);
        System.out.println("after close");
        waterMelon.closeBooths(booths);
    }
}
