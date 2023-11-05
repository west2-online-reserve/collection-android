package work2.mqyxrmwdxh.threadprint;

/**
 * @author 32867
 */
public class Bonus1 {
    public static void main(String[] args) {
        Object obj = new Object();
        int[] firstArr = {1, 3, 5, 7, 9};
        int[] laterArr = {2, 4, 6, 8, 10};
        FirstPrintThread t1 = new FirstPrintThread(firstArr, obj);
        LaterPrintThread t2 = new LaterPrintThread(laterArr, obj);
        t1.setName("FirstPrintThread");
        t2.setName("LaterPrintThread");
        t1.start();
        t2.start();
    }
}

class FirstPrintThread extends Thread {
    int[] firstArr;
    Object obj;

    FirstPrintThread(int[] firstArr, Object obj) {
        this.firstArr = firstArr;
        this.obj = obj;
    }

    @Override
    public void run() {
        for (int num : firstArr) {
            // 不要用Integer作为锁对象，会变，不是final
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + "------>" + num);
                try {
                    obj.notifyAll();
                    obj.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        obj.notifyAll();
    }
}

class LaterPrintThread extends Thread {
    int[] laterArr;
    Object obj;

    LaterPrintThread(int[] laterArr, Object obj) {
        this.obj = obj;
        this.laterArr = laterArr;
    }

    @Override
    public void run() {
        // 让上一个数组先输出
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int num : laterArr) {
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + "------>" + num);
                try {
                    obj.notifyAll();
                    obj.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        obj.notifyAll();
    }
}

