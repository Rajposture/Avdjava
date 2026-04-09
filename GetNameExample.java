class GetNameExample extends Thread {
    public void run() {
        System.out.println("Thread is executing");
    }

    public static void main(String[] args) {
        GetNameExample t1 = new GetNameExample();
        GetNameExample t2 = new GetNameExample();

        System.out.println("Name of Thread 1: " + t1.getName());
        System.out.println("Name of Thread 2: " + t2.getName());
    }
}
