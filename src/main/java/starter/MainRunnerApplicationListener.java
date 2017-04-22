package starter;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by Evegeny on 22/04/2017.
 */
@Component
public class MainRunnerApplicationListener {
    @Autowired
    private ConfigurableListableBeanFactory factory;

    @EventListener
    @SneakyThrows
    public void handleMainMethods(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();
            if (beanClassName == null) {
                continue;
            }
            Class<?> beanClass = ClassUtils.resolveClassName(beanClassName, ClassLoader.getSystemClassLoader());
            Method[] methods = beanClass.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Main.class)) {
                    Object bean = context.getBean(name);
                    Method currentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                    currentMethod.invoke(bean);
                }
            }

        }

    }
}












