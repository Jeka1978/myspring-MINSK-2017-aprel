package abc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Evegeny on 21/04/2017.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("abc");
        WorkService workService = context.getBean(WorkService.class);
        System.out.println();
    }
}
