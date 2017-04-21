package profiles;/**
 * Created by Evegeny on 21/04/2017.
 */

import org.springframework.context.annotation.Profile;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Profile("PROD")
public @interface Prod {
}
