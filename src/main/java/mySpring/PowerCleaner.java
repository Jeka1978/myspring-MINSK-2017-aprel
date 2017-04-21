package mySpring;

import org.fluttercode.datafactory.impl.DataFactory;

import java.util.Random;

/**
 * Created by Evegeny on 21/04/2017.
 */
@Transactional
public class PowerCleaner implements Cleaner {
    @InjectRandomInt(min = 2, max = 5)
    private int repeat;

    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("FFFffffffffshhhhhhhhh");
        }
    }
}
