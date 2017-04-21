package mySpring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by Evegeny on 21/04/2017.
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private Reflections scanner;

    private List<ObjectConfigurer> configurers = new ArrayList<>();
    private List<ProxyConfigurer> proxyConfigurers = new ArrayList<>();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
        scanner = new Reflections("mySpring");
        initConfigurers();
        initProxyConfigurers();
    }

    private void initConfigurers() throws InstantiationException, IllegalAccessException {
        Set<Class<? extends ObjectConfigurer>> objectConfigurers = scanner.getSubTypesOf(ObjectConfigurer.class);
        for (Class<? extends ObjectConfigurer> objectConfigurer : objectConfigurers) {
            configurers.add(objectConfigurer.newInstance());
        }
    }

    private void initProxyConfigurers() throws InstantiationException, IllegalAccessException {
        Set<Class<? extends ProxyConfigurer>> proxyConfigurers = scanner.getSubTypesOf(ProxyConfigurer.class);
        for (Class<? extends ProxyConfigurer> proxyConfigurer : proxyConfigurers) {
            this.proxyConfigurers.add(proxyConfigurer.newInstance());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        type = findImpl(type);

        T t = type.newInstance();

        configure(t);

        invokeInitMethods(type, t);

        t = wrapWithProxy(type, t);

        return t;

    }








    private <T> T wrapWithProxy(Class<T> type, T t) {
        for (ProxyConfigurer proxyConfigurer : proxyConfigurers) {
            t = proxyConfigurer.wrapWithProxy(t, type);
        }
        return t;
    }

    private <T> void invokeInitMethods(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(t);
            }
        }
    }


    private <T> void configure(T t) {
        for (ObjectConfigurer configurer : configurers) {
            configurer.configure(t);
        }
    }

    private <T> Class<T> findImpl(Class<T> type) {
        if (type.isInterface()) {
            type = resolveImpl(type);
        }
        return type;
    }

    private <T> Class<T> resolveImpl(Class<T> type) {
        Class impl = config.getImpl(type);
        if (impl == null) {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
            if (classes.size() != 1) {
                throw new RuntimeException("0 or more than 1 impl find for " + type + " please map needed one in your config file");
            } else {
                impl = classes.iterator().next();
            }
        }
        return impl;
    }


}











