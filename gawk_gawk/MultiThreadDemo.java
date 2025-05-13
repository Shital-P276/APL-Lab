// Task 1: Extending Thread class
class TaskOne extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("TaskOne - Count: " + i);
            try {
                Thread.sleep(500); // Pause for 0.5 seconds
            } catch (InterruptedException e) {
                System.out.println("TaskOne interrupted");
            }
        }
    }
}

// Task 2: Implementing Runnable interface
class TaskTwo implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("TaskTwo - Count: " + i);
            try {
                Thread.sleep(700); // Pause for 0.7 seconds
            } catch (InterruptedException e) {
                System.out.println("TaskTwo interrupted");
            }
        }
    }
}

// Main class
public class MultiThreadDemo {
    public static void main(String[] args) {
        // Thread using extended class
        TaskOne t1 = new TaskOne();

        // Thread using Runnable interface
        Thread t2 = new Thread(new TaskTwo());

        // Start both threads
        t1.start();
        t2.start();
    }
}
