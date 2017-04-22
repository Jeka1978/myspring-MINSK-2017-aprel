package starter;

/**
 * Created by Evegeny on 22/04/2017.
 */
public class Counter {
    private static Counter ourInstance = new Counter();
    private int counter;

    public static Counter getInstance() {
        return ourInstance;
    }

    private Counter() {
    }

    public void increment() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
