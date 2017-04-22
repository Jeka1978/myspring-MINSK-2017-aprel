package starter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Evegeny on 22/04/2017.
 */
@Configuration
public class InfraConf {
    @Bean
    public MainRunnerApplicationListener listener(){
        return new MainRunnerApplicationListener();
    }

    @Bean
    public BeanDefinitionCompleterBeanPostProcessor beanDefinitionCompleterBeanPostProcessor(){
        return new BeanDefinitionCompleterBeanPostProcessor();
    }
}
