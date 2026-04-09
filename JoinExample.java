            public class JoinExample {
                public static void main(String[] args) {
                    Thread t1 = new Thread(() -> {
                        System.out.println("Thread 1 is running");
                    });
                    Thread t2 = new Thread(() -> {
                        System.out.println("Thread 2 is running");
                    });

                    t1.start();
                    try {
                        t1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    t2.start();
                }
            }