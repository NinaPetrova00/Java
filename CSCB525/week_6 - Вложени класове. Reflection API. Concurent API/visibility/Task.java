package visibility;

public class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread name:" + Thread.currentThread().getName());
    }
}
