package mySpring;

/**
 * Created by Evegeny on 21/04/2017.
 */
public class ConsoleSpeaker implements Speaker {
    @Override
    public void say(String message) {
        System.out.println(message);
    }
}
