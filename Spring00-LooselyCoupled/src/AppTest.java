import service.FullTimeMentor;
import service.MentorAccount;
import service.PartTimeMentor;

public class AppTest {
    public static void main(String[] args) {

        //'new' keyword is giving dependency - tightly coupling (not prefereble)

        //FullTimeMentor fullTime = new FullTimeMentor();
        //MentorAccount mentor = new MentorAccount(fullTime);

        PartTimeMentor partTime = new PartTimeMentor();
        MentorAccount mentor = new MentorAccount(partTime);

        mentor.manageAccount();
    }
}

