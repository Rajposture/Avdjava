class SleepExample extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("Count: " + i);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        SleepExample t1 = new SleepExample();
        t1.start();
    }
}

