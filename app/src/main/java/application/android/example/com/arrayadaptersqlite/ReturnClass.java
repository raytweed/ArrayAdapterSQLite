package application.android.example.com.arrayadaptersqlite;

public class ReturnClass {
    private String name;
    private String number;
    private  String subject;
    public ReturnClass(String Mname,String Mnumber,String Msubject){
        name=Mname;
        number=Mnumber;
        subject=Msubject;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getSubject() {
        return subject;
    }
}
