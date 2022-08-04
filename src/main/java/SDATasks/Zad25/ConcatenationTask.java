package SDATasks.Zad25;

public class ConcatenationTask implements Runnable {
    //private static boolean isRunning = true;
    private int repetition;
    private String character;
    private Thread concatenatenation = new Thread(this);

    public ConcatenationTask(int repetition, String character) {
        this.repetition = repetition;
        this.character = character;
    }

    public void startTask() {
        concatenatenation.start();
    }

    public void abort() {
        concatenatenation.interrupt();
        //isRunning = false;
    }
    @Override
    public void run() {
        String result = "";
        for (int i = 0; i < repetition; i++) {
            if (concatenatenation.isInterrupted()) {
                break;
            }
            result += character;
        }
        System.out.println(result);
        System.out.println("Concatenated strings: " + result.length());
    }
}
