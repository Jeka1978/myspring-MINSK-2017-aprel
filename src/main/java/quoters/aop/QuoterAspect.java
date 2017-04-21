package quoters.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 21/04/2017.
 */
@Component
@Aspect
public class QuoterAspect {
    @Before("execution(* quoters..*.say*(..))")
    public void handleSayMethods() {
        System.out.println("а теперь цитата:");
    }
}
