
import java.util.ArrayList;

public class CandidateQue {

    ArrayList<Candidate> candidates = new ArrayList<Candidate>();

    public void addCandidate(Candidate candidate){
        synchronized (this.candidates) {
            this.candidates.add(candidate);
        }
    }

    public Candidate nextCandidate(){
        synchronized (this.candidates){
            return this.candidates.get(0);
        }
    }

    public void removeCandidate(Candidate candidate){
        synchronized (this.candidates) {
            this.candidates.remove(candidate);
        }
    }

}

