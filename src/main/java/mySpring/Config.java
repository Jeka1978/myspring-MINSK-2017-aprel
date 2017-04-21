package mySpring;

/**
 * Created by Evegeny on 21/04/2017.
 */
public interface Config {
    <T> Class getImpl(Class<T> type);
}
