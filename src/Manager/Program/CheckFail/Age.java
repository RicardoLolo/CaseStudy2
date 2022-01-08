package Manager.Program.CheckFail;

public class Age extends Exception {
    @Override
    public String getMessage(){
        return "not of age allowed";
    }
}
