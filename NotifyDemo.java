class NotifyDemo {

    public static void main(String[] args) {

        Object lock = new Object();

        Thread waiter = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Waiting thread started");
                    lock.wait();
                    System.out.println("Waiting thread resumed");
                } catch (Exception e) {}
            }
        });

        Thread notifier = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Notifier thread sending notify");
                lock.notify();   // wakes one waiting thread
            }
        });

        waiter.start();

        try { Thread.sleep(2000); } catch (Exception e) {}

        notifier.start();
    }
}