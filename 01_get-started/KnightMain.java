import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class KnightMain {
    public static void main(String[] args) throws Exception {
//        ApplicationContext context = new ClassPathXmlApplicationContext("knight.xml");
//        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }
}