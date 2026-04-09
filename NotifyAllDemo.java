class NotifyAllDemo {

    public static void main(String[] args) {

        Object lock = new Object();

        Runnable task = () -> {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getName() + " waiting");
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + " resumed");
                } catch (Exception e) {}
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        Thread notifier = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Notifier calling notifyAll");
                lock.notifyAll();    // wakes all waiting threads
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try { Thread.sleep(2000); } catch (Exception e) {}

        notifier.start();
    }
}