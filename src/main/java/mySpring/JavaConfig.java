package mySpring;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Evegeny on 21/04/2017.
 */
public class JavaConfig implements Config {

    private Map<Class, Class> ifc2Impl = new HashMap<>();

    public JavaConfig() {
        ifc2Impl.put(Cleaner.class, PowerCleaner.class);
    }

    @Override
    public <T> Class getImpl(Class<T> type) {
        return ifc2Impl.get(type);
    }
}









