package mySpring;

/**
 * Created by Evegeny on 21/04/2017.
 */
@Transactional
public class CleanerImpl implements Cleaner {
    @Override
    public void clean() {
        System.out.println("VVVVVVVVVVVvvvvvvvvv");
    }
}
