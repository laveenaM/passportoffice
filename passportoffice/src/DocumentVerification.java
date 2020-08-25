public class DocumentVerification extends Section {

    public DocumentVerification(){
        super("VERIFY");
        this.officers.add(new Officer(2, this));
        this.officers.add(new Officer(3, this));
        this.officers.add(new Officer(3, this));

    }



}
