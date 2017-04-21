package profiles;

import org.springframework.stereotype.Repository;

/**
 * Created by Evegeny on 21/04/2017.
 */
@Repository
@Prod
public class ProdDao implements Dao {
    @Override
    public void save() {
        System.out.println("saving to real DB (MONGO)");
    }
}
