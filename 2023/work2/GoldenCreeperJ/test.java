package GoldenCreeperJ;

import java.time.LocalDate;
/**
 * @author GoldenCreeperJ
 * @date 2023/11/7
 */
public class test extends Thread{
    public static void main(String[] args) throws InsufficientBalanceException, AnimalNotFountException {
        try{
            MyAnimalShop myAnimalShop = new MyAnimalShop(500,true, LocalDate.of(2023,11,7));
            myAnimalShop.buyNewAnimals(new Cat("1ha",2,"male"));
            myAnimalShop.buyNewAnimals(new Dog("2ha",3,"female"));
            myAnimalShop.buyNewAnimals(new ChineseRuralDog("3ha",4,"male",true));
            myAnimalShop.treatCustomers(new Customer("xiaoming",1,myAnimalShop.getNowdate()), new Dog());
            myAnimalShop.treatCustomers(new Customer("xiaohong",2,myAnimalShop.getNowdate()), new ChineseRuralDog());
            myAnimalShop.closeBusiness();
            myAnimalShop.closeBusiness();
            myAnimalShop.treatCustomers(new Customer("xiaoming",1,myAnimalShop.getNowdate()), new Dog());
            myAnimalShop.openBusiness();
            myAnimalShop.openBusiness();
            myAnimalShop.treatCustomers(new Customer("xiaohong",2,myAnimalShop.getNowdate()), new Cat());
            myAnimalShop.closeBusiness();
        } catch (InsufficientBalanceException | AnimalNotFountException e) {
            System.out.println(e);
        }


        judge("GoldenCreeperJ@foxmail.com");
        judge("@foxmail.com");
        judge("GoldenCreeperJ@.com");
        judge("GoldenCreeper@Jfoxmailcom");
        run(new int[]{1,3,5,7,9},new int[]{2,4,6,8,10});
    }

    public static void judge(String eMail) {
        String regex = "\\w+@\\w+\\.com";
        if (eMail.matches(regex)) {
            System.out.println("邮箱格式合法!\n");
        } else {
            System.out.println("邮箱格式非法!\n");
        }
    }
    public static void run(int[] a,int[] b) {
        Thread thread1 = new Thread(() -> {
            for (int num : a) {
                System.out.printf("%d ",num);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int num : b) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.printf("%d ",num);
            }
        });

        thread1.start();
        thread2.start();
        }
    }