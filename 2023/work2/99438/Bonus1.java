import java.util.Scanner;
import java.util.concurrent.locks.LockSupport;

public class Bonus1 {

    static Thread t1 = null;
    static Thread t2 = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            String input1 = sc.nextLine();
            String input2 = sc.nextLine();
            String[] arr1 = input1.split(",");
            String[] arr2 = input2.split(",");
            int[] array1 = new int[arr1.length];
            for(int i =0;i<array1.length;i++) {
                array1[i] = Integer.parseInt(arr1[i]);
            }
            int[] array2 = new int[arr2.length];
            for(int i =0;i<array2.length;i++) {
                array2[i] = Integer.parseInt(arr2[i]);
            }
            t1 = new Thread(()->{
                for(int temp:array1){
                    System.out.print(temp + " ");
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            },"t1");

            t2 = new Thread(()->{
                for(int temp:array2){
                    LockSupport.park();
                    System.out.print(temp + " ");
                    LockSupport.unpark(t1);
                }
            },"t2");

            t1.start();
            t2.start();
        }
    }

}
