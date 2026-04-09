import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
    private int taskNumber;

    public Task(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void run() {
        System.out.println("Executing Task " + taskNumber +
                " by " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Completed Task " + taskNumber);
    }
}

public class ThreadPoolDemo {
    public static void main(String[] args) {

        // Creating Thread Pool of size 3
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submitting 6 Tasks
        for (int i = 1; i <= 6; i++) {
            Task task = new Task(i);
            executor.submit(task);
        }

        // Shutdown Executor
        executor.shutdown();

        System.out.println("All Tasks Submitted");
    }
}