import java.util.Timer;
import java.util.TimerTask;

public class Officer {

    boolean isBusy = false;
    int processTime;
    Section section;
    Timer timer ;
    Candidate candidate;


    public Officer(int processTime, Section section){
        this.processTime = processTime*1000;
        this.section = section;
    }

    public void startWorkForCandidate(Candidate candidate) {
        this.isBusy = true;
        this.timer = new Timer();
      //  System.out.println("officer "+ this.section.name +" started working : "+candidate.candidateId);
        TimerTask task = new OfficerHelper(this);
        this.candidate = candidate;

        timer.schedule(task, this.processTime);
    }

    public void workCompleted() {
    //    System.out.println("officer "+ this.section.name +" completed his task : "+this.candidate.candidateId);
        this.isBusy = false;
        timer.cancel();
        section.workCompleted(this);
    }


}

class OfficerHelper extends TimerTask
{
    Officer officer;
    OfficerHelper(Officer officer) {
        this.officer = officer;
    }
    public void run()
    {
     //   System.out.println("officer "+ officer.section.name +" task is in progress : "+officer.candidate.candidateId);

        officer.workCompleted();
    }
}

