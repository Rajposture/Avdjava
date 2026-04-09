class StartExample extends Thread {
    public void run() {
        System.out.println("Thread started successfully");
    }

    public static void main(String[] args) {
        StartExample t1 = new StartExample();
        t1.start();
    }
}

