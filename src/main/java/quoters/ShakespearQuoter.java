package quoters;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Evegeny on 21/04/2017.
 */
@Component
@Setter
@Scope("prototype")
@Book
public class ShakespearQuoter implements Quoter {
    @Value("${shake}")
    private String message;

    @Override
    @PostConstruct
    public void sayQuote() {
        System.out.println(message);
    }

    @PreDestroy
    public void killaLL(){}
}
