package quoters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Evegeny on 21/04/2017.
 */
@Component
public class TalkingRobotImpl implements TalkingRobot {
    @Film
    private List<Quoter> quoters = Arrays.asList((Quoter) () ->
            System.out.println("This is default"));

    @Override
    @PostConstruct
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }
}
