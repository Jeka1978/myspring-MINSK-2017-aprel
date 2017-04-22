package starter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Evegeny on 22/04/2017.
 */
@Configuration
public class MainTestConfiguration {
    @Bean
    public MyFakeSingleton fakeSingleton(){
        return new MyFakeSingleton();
    }
}
