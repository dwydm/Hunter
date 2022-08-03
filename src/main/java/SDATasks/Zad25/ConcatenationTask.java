package SDATasks.Zad25;

public class ConcatenationTask {
    private static boolean isRunning = true;
    private int repetition;
    private String character;

    public ConcatenationTask(int repetition, String character) {
        this.repetition = repetition;
        this.character = character;
    }

    public void concatenate(int repetitionCount, String character) {
        String result = "";
        for (int i = 0; i < repetitionCount; i++) {
            if(!isRunning){
                break;
            }
            result += character + i;
        }
        System.out.println(result);
    }

    public void startTask() {
        isRunning = true;
        concatenate(repetition, character);
    }

    public void abort() {
        isRunning = false;
    }


}
