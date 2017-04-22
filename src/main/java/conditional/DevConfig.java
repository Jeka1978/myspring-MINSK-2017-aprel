package conditional;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by Evegeny on 23/03/2016.
 */
@Configuration
@PropertySource("classpath:config/dev.properties")
@Windows(true)
@EnableAspectJAutoProxy
public class DevConfig {





}
