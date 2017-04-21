package profiles;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Evegeny on 21/04/2017.
 */
@Configuration
@EnableScheduling
@ComponentScan
public class MyConf {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(MyConf.class);
    }
}
