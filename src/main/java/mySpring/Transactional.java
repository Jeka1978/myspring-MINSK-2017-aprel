package mySpring;/**
 * Created by Evegeny on 21/04/2017.
 */

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface Transactional {
}
