package hw_10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide bean name as an argument (junior, middle, senior).");
            return;
        }
        String beanName = args[0];

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Programmer programmer = context.getBean(beanName, Programmer.class);
        programmer.doCoding();
    }
}
