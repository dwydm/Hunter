package SDAKurs.Dzien10;

public class ThreadTask {
    public static void main(String[] args) {
        Task task = new Task();
        Runnable runTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000; i++) {
                    System.out.println(i + "Cats");
                }
            }
        };

        Thread worker = new Thread(task);
        Thread worker2 = new Thread(runTask);
        worker.start();
        worker2.start();

    }
}
