class GetPriorityExample extends Thread {
    public void run() {
        System.out.println("Thread running");
    }

    public static void main(String[] args) {
        GetPriorityExample t1 = new GetPriorityExample();
        GetPriorityExample t2 = new GetPriorityExample();

        t1.setPriority(2);
        t2.setPriority(9);

        System.out.println("Priority of t1: " + t1.getPriority());
        System.out.println("Priority of t2: " + t2.getPriority());
    }
}
