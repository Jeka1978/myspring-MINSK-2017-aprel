package profiles;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 21/04/2017.
 */
@Service
@RequiredArgsConstructor
public class MyService {
    private final Dao dao;

    @Scheduled(initialDelay = 1,fixedDelay = 1000)
    public void doWork(){
        System.out.println("Working в поте лица...");
        dao.save();
    }

}
