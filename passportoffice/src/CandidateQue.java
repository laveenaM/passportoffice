
import java.util.ArrayList;

public class CandidateQue {

    ArrayList<Candidate> candidates = new ArrayList<Candidate>();

    public void addCandidate(Candidate candidate){
            this.candidates.add(candidate);
    }

    public Candidate nextCandidate(){
            return this.candidates.get(0);

    }

    public void removeCandidate(Candidate candidate){
            this.candidates.remove(candidate);
    }

}

