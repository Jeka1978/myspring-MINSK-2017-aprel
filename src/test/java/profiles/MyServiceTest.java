package profiles;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

import static org.junit.Assert.*;

/**
 * Created by Evegeny on 21/04/2017.
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MyConf.class)
@ActiveProfiles("PROD")
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class MyServiceTest {

    @Autowired
    private MyService myService;

    @PostConstruct
    public void init(){
        System.out.println("22222");
    }


    @Test
    public void doWork() throws Exception {
        myService.doWork();
    }

    @Test
    public void doWork2() throws Exception {
        myService.doWork();
    }

}






