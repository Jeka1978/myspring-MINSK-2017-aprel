package starter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Evegeny on 22/04/2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {InfraConf.class,MainTestConfiguration.class})
public class InfraConfTest {


    @Test
    public void testMainIsWorking() throws Exception {
        Assert.assertEquals(1,Counter.getInstance().getCounter());
    }

}