import service.FullTimeMentor;
import service.MentorAccount;

public class AppTest {
    public static void main(String[] args) {

        FullTimeMentor fullTime = new FullTimeMentor();

        MentorAccount mentor = new MentorAccount(fullTime);

        mentor.manageAccount();
        }
    }

