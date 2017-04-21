package abc;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 21/04/2017.
 */
@Component
@Lazy
public class MyService {
    public MyService() {
        System.out.println("kdjsfalsdjfhlaksjdfhlad");
    }

    public void x(){
        System.out.println("XXXXXXXXXX");
    }
}
