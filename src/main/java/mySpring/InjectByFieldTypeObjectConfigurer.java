package mySpring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Evegeny on 21/04/2017.
 */
public class InjectByFieldTypeObjectConfigurer implements ObjectConfigurer {
    private Random random = new Random();

    @Override
    @SneakyThrows
    public void configure(Object o) {
        Class<?> type = o.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByFieldType.class)) {
                field.setAccessible(true);
                Object object = ObjectFactory.getInstance().createObject(field.getType());
                field.set(o,object);
            }
        }
    }
}










