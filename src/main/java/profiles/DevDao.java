package profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * Created by Evegeny on 21/04/2017.
 */
@Repository
@Profile("DEV")
//spring.profiles.active
public class DevDao implements Dao {
    @Override
    public void save() {
        System.out.println("Saving to oracle (slowly)");
    }
}
