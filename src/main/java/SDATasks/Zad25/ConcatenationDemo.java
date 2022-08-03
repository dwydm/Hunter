package SDATasks.Zad25;

public class ConcatenationDemo {
    public static void main(String[] args) {

        ConcatenationTask concatenationTask = new ConcatenationTask(5000,"D");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                }catch (InterruptedException e) {

                }
                concatenationTask.abort();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        concatenationTask.startTask();

    }
}
