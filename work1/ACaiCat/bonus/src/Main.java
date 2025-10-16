import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static void main() {
        var arr1 = new int[]{1, 3, 5, 7, 9};
        var arr2 = new int[]{2, 4, 6, 8, 10};
        printArraysAlternately(arr1, arr2);

        var validEmail = "13110818005@qq.com";
        var notValidEmail = "13110818005qq.com";

        System.out.println();

        System.out.printf("%s: %b\n", validEmail, isValidEmail(validEmail));
        System.out.printf("%s: %b\n", notValidEmail, isValidEmail(notValidEmail));

    }

    public static boolean isValidEmail(String address) {
        return address.matches("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
    }


    public static void printArraysAlternately(int[] arr1, int[] arr2) {
        var lock = new ReentrantLock();
        var condition = lock.newCondition();

        var thread1 = new PrintThread(arr1, true, lock, condition);
        var thread2 = new PrintThread(arr2, false, lock, condition);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    static class PrintThread extends Thread {
        private final int[] array;
        private final boolean isThread1;
        private final ReentrantLock lock;
        private final Condition condition;

        public PrintThread(int[] array, boolean isThread1, ReentrantLock lock, Condition condition) {
            this.array = array;
            this.isThread1 = isThread1;
            this.lock = lock;
            this.condition = condition;

        }

        public void print() throws InterruptedException {
            lock.lock();
            try {
                if (!isThread1 && lock.getWaitQueueLength(condition) == 0) {
                    condition.await();
                }
                for (var num : array) {
                    System.out.print(num + " ");
                    condition.signal();
                    condition.await();
                }
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }

        @Override
        public void run() {
            try {
                print();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
