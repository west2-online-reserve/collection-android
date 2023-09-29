//创建一个简单的西瓜摊类
package com.wanandaodao.code1;
import java.util.Scanner;
class waterMelon
{
    private long ID;//摊号
    public void setID(long ID_){ID=ID_;}
    public long getID(){return ID;}
    private String name;//摊主姓名
    public void setName(String name_){name=name_;}
    public String getName(){return name;}
    private int solvingTotal;//在售西瓜数
    public void setSolvingTotal(int total){solvingTotal=total;}
    public int getTotal(){return solvingTotal;}
    private boolean isClosed;//是否关门
    public void setClosed(boolean closed){isClosed=closed;}
    public boolean getClosed(){return isClosed;}
    public waterMelon(long ID_,String name_,int total,boolean closed)
    {
        ID=ID_;
        name=name_;
        solvingTotal=total;
        isClosed=closed;
    }
    public void toString(waterMelon w)
    {
        System.out.printf("%-10s %-7d %-7d %s\n",name,ID,solvingTotal,isClosed);
    }
    public static void purchase(waterMelon business,int purchaseNum)
    {
        if(purchaseNum<=0)
        {
            System.out.println("Purchase failed, purchase quantity must be positive");
            return;
        }
        if(business.isClosed==true)
        {
            System.out.println("Purchase failed, this stall owner has already closed");
            return;
        }
        int solvingTatal=business.getTotal();//在售西瓜数量
        if(solvingTatal<purchaseNum)
        {
            System.out.println("Purchase failed. This vendor has fewer watermelons than you need");
            return;
        }
        business.setSolvingTotal(solvingTatal-purchaseNum);
        System.out.println("Purchase successful");
    }
    public void restock(int purchaseQuantity)
    {
        if(purchaseQuantity>200)
        {
            System.out.println("The purchase quantity cannot exceed 200!");
            return;
        }
        solvingTotal+=purchaseQuantity;
    }
    public static void closeBooths(waterMelon[]booths)
    {
        int length= booths.length;
        for(int i=0;i<length;i++)
        {
            if(booths[i].getClosed()==false)
                booths[i].setClosed(true);
            else
                booths[i].toString(booths[i]);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        waterMelon w1=new waterMelon(1234,"张三1",200,false);
        waterMelon w2=new waterMelon(1235,"张三2",200,false);
        waterMelon w3=new waterMelon(1236,"张三3",200,true);
        waterMelon w4=new waterMelon(1237,"张三4",200,false);
        waterMelon w5=new waterMelon(1238,"张三5",200,true);
        waterMelon w6=new waterMelon(1239,"张三6",200,false);
        waterMelon w7=new waterMelon(1240,"张三7",200,true);
        w1.toString(w1);
        System.out.println(w1.getTotal());
        waterMelon.purchase(w1,300);
        waterMelon.purchase(w3,100);
        waterMelon.purchase(w1,100);
        System.out.println(w1.getTotal());
        waterMelon[]booths={w1,w2,w3,w4,w5,w6,w7};
        System.out.println("before close");
        waterMelon.closeBooths(booths);
        System.out.println("after close");
        waterMelon.closeBooths(booths);
    }
}
