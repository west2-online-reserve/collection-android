package com.baidu.www.booth;

import com.baidu.www.finaltest.Booth;

public class BoothTest {
    public static void main(String[] args) {
        com.baidu.www.finaltest.Booth[] booths = new com.baidu.www.finaltest.Booth[3];
        booths[0] = new com.baidu.www.finaltest.Booth(33, "我的西瓜摊", 150, false);
        booths[1] = new com.baidu.www.finaltest.Booth(22, "我的西瓜摊", 100, false);
        booths[2] = new com.baidu.www.finaltest.Booth(11, "我的西瓜摊", 50, false);

        booths[0].purchase(booths[0], 50);
        booths[0].purchase(booths[0], -1);
        booths[0].purchase(booths[0], 200);
        booths[1].restock(50);
        booths[1].restock(201);

        com.baidu.www.finaltest.Booth.closeBooths(booths);
        booths[0].purchase(booths[0], 50);
        Booth.closeBooths(booths);
    }
}
