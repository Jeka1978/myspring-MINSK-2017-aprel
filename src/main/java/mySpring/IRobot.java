package mySpring;

import javax.annotation.PostConstruct;

/**
 * Created by Evegeny on 21/04/2017.
 */
public class IRobot {
    @InjectByFieldType
    private Speaker speaker;
    @InjectByFieldType
    private Cleaner cleaner;

    @PostConstruct
    public void init(){
        System.out.println(cleaner.getClass());
    }


    public void cleanRoom() {
        speaker.say("Started");
        cleaner.clean();
        speaker.say("Finished");
    }
}
