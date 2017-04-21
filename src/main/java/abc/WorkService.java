package abc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 21/04/2017.
 */
@Service
@ComponentScan(lazyInit = true, basePackages = "com.sam")
public class WorkService {
    @Autowired
    private MyService myService;

    public WorkService(@Lazy MyService myService) {
        this.myService = myService;
        myService.x();
    }
}
