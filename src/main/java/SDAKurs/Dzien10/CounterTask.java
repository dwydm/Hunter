package SDAKurs.Dzien10;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterTask implements Runnable{

    private Thread thread1;
    private Thread thread2;
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int counter = 0;


    public CounterTask() {
        thread1 = new Thread(this);
        thread2 = new Thread(this);
    }
    public int getCounter() {
        return atomicInteger.get();
    }

    public void joinAll() throws InterruptedException {
        thread1.join();
        thread2.join();
    }


    public void startAll() {
        thread1.start();
        thread2.start();
    }

/*    private synchronized void increaseCounter() {
        counter++;
    }*/


    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            atomicInteger.getAndIncrement();
            //increaseCounter();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CounterTask counterTask = new CounterTask();

        counterTask.startAll();
        counterTask.joinAll();
        System.out.println(counterTask.getCounter());
    }
}
