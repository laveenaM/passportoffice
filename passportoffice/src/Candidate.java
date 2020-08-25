public class Candidate {
    int candidateId;
    int token;

    public Candidate(int candidateId){
        this.candidateId=candidateId;

    }



    public void SubmitDocument(){
        System.out.println("received token");
    }
}
