package SDATasks.Zad25;

public class ConcatenationDemo {
    public static void main(String[] args) {

        ConcatenationTask concatenationTask = new ConcatenationTask(200_000,"D");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                concatenationTask.abort();
            }
        };
        Thread thread = new Thread(runnable);
        concatenationTask.startTask();
        thread.start();

    }
}
