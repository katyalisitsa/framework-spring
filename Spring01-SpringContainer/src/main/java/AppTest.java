import interfaces.Mentor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
    public static void main(String[] args) {

        //Container by using interfaces

        BeanFactory container = new ClassPathXmlApplicationContext("config.xml");

        //Down cast
        Mentor mentorFullTime = (Mentor) container.getBean("fullTimeMentor");
        mentorFullTime.createAccount();

        Mentor mentorPartTime = (Mentor) container.getBean("partTimeMentor");
        mentorPartTime.createAccount();

        //**************Another Way**********************************//

        ApplicationContext container2 = new ClassPathXmlApplicationContext("config.xml");
        //Instead of downcasting
        Mentor mentor2 = container2.getBean("fullTimeMentor", Mentor.class);
    }
}
