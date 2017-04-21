package mySpring;

/**
 * Created by Evegeny on 21/04/2017.
 */
public interface ProxyConfigurer {
    <T> T wrapWithProxy(T t, Class<T> type);
}
