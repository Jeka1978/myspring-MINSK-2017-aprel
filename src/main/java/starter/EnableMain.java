package starter;/**
 * Created by Evegeny on 22/04/2017.
 */

import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Import(InfraConf.class)
public @interface EnableMain {
}
