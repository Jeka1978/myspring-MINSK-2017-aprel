package mySpring;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Evegeny on 21/04/2017.
 */
public class TransactionProxyConfigurer implements ProxyConfigurer {
    @Override
    public <T> T wrapWithProxy(T t, Class<T> type) {

        if (type.isAnnotationPresent(Transactional.class)) {
            return (T) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("***********TRNASACTION OPEN**************");
                    Object retVal = method.invoke(t, args);
                    System.out.println("***********TRNASACTION CLOSE**************");
                    return retVal;
                }
            });
        }else {
            return t;
        }
    }
}
