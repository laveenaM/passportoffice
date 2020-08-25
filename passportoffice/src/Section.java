import java.util.ArrayList;

public class Section {
    CandidateQue candidateQue = new CandidateQue();
    ArrayList<Officer> officers = new ArrayList<Officer>();
    Section nextSection ;
    String name;

    public Section(String name){
        this.name = name;
    }

    public void addToQue(Candidate candidate){
        this.candidateQue.addCandidate(candidate);
    }

    public Candidate NextCandidate(){
        return this.candidateQue.nextCandidate();
    }

    public void workCompleted(Officer officer) {
        if(this.nextSection != null) {
            this.nextSection.processCandidate(officer.candidate);
        }
        this.assignNextCandidate();
    }


    public void assignNextCandidate() {
        //Check for the free officers
        if(this.candidateQue.candidates.size() > 0) {
            for (Officer aOfficer : this.officers) {
                if (!aOfficer.isBusy) {
                    Candidate candidate = this.candidateQue.nextCandidate();
                    this.candidateQue.removeCandidate(candidate);
                    aOfficer.startWorkForCandidate(candidate);
                    break;
                }
            }
        }
    }

    public void processCandidate(Candidate candidate){
        this.addToQue(candidate);
        this.assignNextCandidate();
    }

}


