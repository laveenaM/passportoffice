import java.util.ArrayList;

public class BiomatricsSubmission extends Section{

    ArrayList<Candidate> processedCandidates = new ArrayList<Candidate>();

    public BiomatricsSubmission(){
        super("BIO");
        this.officers.add(new Officer(3, this));
        this.officers.add(new Officer(3, this));
        this.officers.add(new Officer(4, this));

    }

    @Override
    public void workCompleted(Officer officer) {
        super.workCompleted(officer);
        System.out.println("work completed in last section : "+officer.candidate.candidateId);
        this.processedCandidates.add(officer.candidate);

    }
}
