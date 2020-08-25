public class DocumentSubmission extends Section{

    public DocumentSubmission(){
        super("SUBMIT");
        this.officers.add(new Officer(4, this));
        this.officers.add(new Officer(2, this));
        this.officers.add(new Officer(4, this));

    }



}
