void main() {
    printArr();
    System.out.println(isLegalMailAddress("abcde"));
    System.out.println(isLegalMailAddress("test@localhost"));
}

void printArr() {
    Integer[] arr1 = {1, 3, 5, 7, 9};
    Integer[] arr2 = {2, 4, 6, 8, 10};
    SynchronousQueue<byte[]> queue = new SynchronousQueue<>();
    byte[] sig = {};
    Thread thread1 = new Thread(() -> {
        for (int i : arr1) {
            try {
                System.out.print(i + " ");
                queue.put(sig);
                queue.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    });
    Thread thread2 = new Thread(() -> {
        for (int i : arr2) {
            try {
                queue.take();
                System.out.print(i + " ");
                queue.put(sig);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    });
    thread1.start();
    thread2.start();
    try {
        thread1.join();
        thread2.join();
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
    System.out.println("Completed!");
}

boolean isLegalMailAddress(String email) {
    if (email == null || email.isEmpty()) {
        return false;
    }
    if (!email.contains("@")) {
        return false;
    }
    String[] emails = email.split("@", -1);
    if (emails.length != 2) {
        return false;
    }
    if (emails[0].isEmpty() || emails[1].isEmpty()) {
        return false;
    }
    return Pattern.matches("[A-Za-z0-9!#$%&'*+/=?^_`{|}~.-]+", emails[0]) && Pattern.matches("[A-Za-z0-9.-]+", emails[1]);
}
