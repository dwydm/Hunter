package SDAKurs.Dzien10;

public class ThreadExample {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000; i++) {
                    System.out.println("New thread example");
                }
            }
        };

        Thread worker = new Thread(task);

        worker.start();

        for (int i = 0; i < 10_000; i++) {
            System.out.println("Message from main");
        }

    }
}
