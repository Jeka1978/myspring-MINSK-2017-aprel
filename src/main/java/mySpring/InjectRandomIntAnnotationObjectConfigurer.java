package mySpring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Evegeny on 21/04/2017.
 */
public class InjectRandomIntAnnotationObjectConfigurer implements ObjectConfigurer {
    private Random random = new Random();

    @Override
    @SneakyThrows
    public void configure(Object o) {
        Class<?> type = o.getClass();
        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                field.setAccessible(true);
                int value = min + random.nextInt(max - min);
                field.set(o, value);
            }
        }
    }
}
