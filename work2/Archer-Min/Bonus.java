public class Bonus {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 7, 9};
        int[] array2 = {2, 4, 6, 8, 10,11,12};

        printArraysInAlternatingThreads(array1, array2);
    }

    public static void printArraysInAlternatingThreads(int[] array1, int[] array2) {
        Thread thread1 = new Thread(new ArrayPrinterRunnable(array1));
        Thread thread2 = new Thread(new ArrayPrinterRunnable(array2));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class ArrayPrinterRunnable implements Runnable {
        private final int[] array;

        public ArrayPrinterRunnable(int[] array) {
            this.array = array;
        }

        @Override
        public void run() {
            for (int num : array) {
                System.out.println(num);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
