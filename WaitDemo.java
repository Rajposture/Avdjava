class WaitDemo {

    public static void main(String[] args) {

        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread waiting...");
                    lock.wait();     // thread goes to waiting state
                    System.out.println("Thread resumed");
                } catch (Exception e) {}
            }
        });

        t1.start();
    }
}
