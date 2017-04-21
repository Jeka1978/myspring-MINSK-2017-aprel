package never_use_switch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Evegeny on 21/04/2017.
 */
@Service
public class MailSender {

    private Map<Integer, MailGenerator> map = new HashMap<>();

    @Autowired
    public void initMap(List<MailGenerator> mailGenerators) {
        for (MailGenerator mailGenerator : mailGenerators) {
            map.put(mailGenerator.mailCode(), mailGenerator);
        }
    }

    @Scheduled(cron = "1/1 * * * * ?")
    public void sendMail(){
        Random random = new Random();
        int mailCode = random.nextInt(3) + 1;

        MailGenerator mailGenerator = map.get(mailCode);
        if (mailGenerator == null) {
            throw new RuntimeException(mailCode + " not supported yet.");
        }
        String html = mailGenerator.generateHtml();
        send(html);


    }

    private void send(String html) {
        System.out.println("sending = " + html);
    }
}
