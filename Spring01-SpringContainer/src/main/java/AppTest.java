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


        //Accept one parameter - config file to create a container
        //Using getBean method by bean id
        //Returns object class - need to downcast (polymorphic) to reference type (left side)
        ApplicationContext container2 = new ClassPathXmlApplicationContext("config.xml");
        //Instead of downcasting - auto downcast
        Mentor mentor2 = container2.getBean("fullTimeMentor", Mentor.class);
    }
}
