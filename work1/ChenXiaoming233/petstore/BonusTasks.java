package petstore;

// Bonus：多线程交替输出数组元素、邮箱格式校验

public final class BonusTasks {
    // 两个数组长度相同时，使用两个线程交替输出元素

    public static void printAlternately(int[] first, int[] second) {
        Object lock = new Object();
        // 0 表示第一个线程，1 表示第二个线程
        int[] turn = {0};
        Thread firstThread = new Thread(() -> {
            for (int i = 0; i < first.length; i++) {
                synchronized (lock) {
                    while (turn[0] != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(first[i] + " ");
                    turn[0] = 1;
                    lock.notifyAll();
                }
            }
        });

        Thread secondThread = new Thread(() -> {
            for (int i = 0; i < second.length; i++) {
                synchronized (lock) {
                    while (turn[0] != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(second[i] + " ");
                    turn[0] = 0;
                    lock.notifyAll();
                }
            }
        });
        firstThread.start();
        secondThread.start();
        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    public static boolean isValidEmail(String email) {
        return email != null
                && email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");
    }
}
