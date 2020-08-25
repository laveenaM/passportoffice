import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

public class CandidateGenerator {
    Timer timer;
    public CandidateGenerator(int seconds, Random random, int noOfCandidates, PassportOffice office) {
        timer = new Timer();
        timer.schedule(new CandidateGeneratorTask(random, noOfCandidates, office), seconds * 1000);
    }

    class CandidateGeneratorTask extends TimerTask {
        Random random;
        int noOfCandidates = 0;
        PassportOffice office;

        CandidateGeneratorTask(Random random, int noOfCandidates, PassportOffice office) {
            this.random =  random;
            this.noOfCandidates = noOfCandidates;
            this.office = office;
        }

        public void run() {
            timer.cancel();

            //Generate number of candidates
            for (int i=0; i<noOfCandidates ; i++) {
                Candidate candidate = new Candidate(this.random.nextInt(10000));
                this.office.processCandidate(candidate);
            }
                System.out.println("generate Candidate" + noOfCandidates);

        }
    }

    public static void main(String args[]) {

        PassportOffice office = new PassportOffice();
        Random random = new Random();
        //Assumption we are starting the Passport office at 9:00 AM now
        new CandidateGenerator(0, random, 4, office); //Immediately(assuming 9am now) generate 20 candidates
        /*new CandidateGenerator((15), random, 10, office); //After 15 Mts generate 40 candidates
        new CandidateGenerator((30), random, 20, office); //After 30 Mts generate 20 candidates
        new CandidateGenerator((45), random, 10, office); //After 45 Mts generate 10 candidates*/
        new CandidateCalculator((30), office); //After 1 hour. The calculator task will print the number of candidates completed*/
    }
}


class CandidateCalculator {
    Timer timer;

    public CandidateCalculator(int seconds, PassportOffice office) {
        timer = new Timer();
        timer.schedule(new CandidateCalculatorTask(office), seconds * 1000);
    }

    class CandidateCalculatorTask extends TimerTask {
        PassportOffice office;

        public CandidateCalculatorTask (PassportOffice office){
            this.office = office;
        }

        public void run() {
            timer.cancel();

            //Print Ask the passport office for number of completed candidates
            System.out.println("Number of candidates completed: "+office.completedCandidates());
        }
    }
}