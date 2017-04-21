package mySpring;

/**
 * Created by Evegeny on 21/04/2017.
 */
public class Main {
    public static void main(String[] args) {
      ObjectFactory.getInstance().createObject(IRobot.class).cleanRoom();
    }
}
