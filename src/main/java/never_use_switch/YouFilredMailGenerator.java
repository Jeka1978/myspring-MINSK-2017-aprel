package never_use_switch;

import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 21/04/2017.
 */
@Component
public class YouFilredMailGenerator implements MailGenerator {
    @Override
    public String generateHtml() {
        //50 lines of business code for building mail
        return "ты уволен, брат!";
    }

    @Override
    public int mailCode() {
        return 3;
    }

}
