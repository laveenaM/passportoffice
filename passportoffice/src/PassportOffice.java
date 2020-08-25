public class PassportOffice {
    TokenSection tokenSection = new TokenSection();
    DocumentSubmission documentSubmission = new DocumentSubmission();
    DocumentVerification documentVerification = new DocumentVerification();
    BiomatricsSubmission biomatricsSubmission = new BiomatricsSubmission();

    public PassportOffice(){
        this.documentSubmission.nextSection = this.documentVerification;
        this.documentVerification.nextSection = this.biomatricsSubmission;
    }

    public void processCandidate(Candidate candidate){
        this.tokenSection.getToken(candidate);
        this.documentSubmission.processCandidate(candidate);
    }

    public int completedCandidates(){
        return this.biomatricsSubmission.processedCandidates.size();
    }
}
