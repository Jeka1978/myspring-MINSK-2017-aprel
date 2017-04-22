package starter;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 22/04/2017.
 */
@Component
@EnableAsync
public class MyFakeSingleton {
    @Main
    @Async
    public void doWork(){
        Counter.getInstance().increment();
    }
}
