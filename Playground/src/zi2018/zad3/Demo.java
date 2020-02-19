package zi2018.zad3;

import java.util.concurrent.ArrayBlockingQueue;

public class Demo {
    public static void main(String ... args) {
        ArrayBlockingQueue<String>q
                = new ArrayBlockingQueue<>(100);
        LoggerThread l
                = new LoggerThread(q, "readyLoggerOne");
        Thread t = new Thread(l);
        t.start();
        q.add("Steady");
        q.add("Go!");
        try {
            Thread.sleep(10000);
        } catch(InterruptedException e) { }
        q.add("Bonus creds...");
        //stop the logger thread & friends
        q.add(LoggerThread.STOPPING_SEQUENCE);
}
}
