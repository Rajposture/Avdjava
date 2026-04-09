class MyTask implements Runnable {

    private String taskName;

    MyTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + " - Execution " + i +
                    " by " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class MultipleThreadsRunnable {
    public static void main(String[] args) {

        MyTask task1 = new MyTask("Task One");
        MyTask task2 = new MyTask("Task Two");
        MyTask task3 = new MyTask("Task Three");

        Thread t1 = new Thread(task1, "Thread-1");
        Thread t2 = new Thread(task2, "Thread-2");
        Thread t3 = new Thread(task3, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
