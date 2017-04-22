package starter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by Evegeny on 22/04/2017.
 */
public class BeanDefinitionCompleterBeanPostProcessor implements BeanPostProcessor {
    @Autowired
    private ConfigurableListableBeanFactory factory;

    @PostConstruct
    public void fixMySelf() {
        BeanDefinition beanDefinition = factory.getBeanDefinition("beanDefinitionCompleterBeanPostProcessor");
        beanDefinition.setBeanClassName(BeanDefinitionCompleterBeanPostProcessor.class.getCanonicalName());
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Method[] methods = bean.getClass().getMethods();
        if (Arrays.stream(methods).anyMatch(method -> method.isAnnotationPresent(Main.class))) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);
            if (beanDefinition.getBeanClassName() == null) {
                beanDefinition.setBeanClassName(bean.getClass().getCanonicalName());
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
