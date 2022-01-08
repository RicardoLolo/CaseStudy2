package Manager.Program.CheckFail;

public class Gender extends Exception {
    @Override
    public String getMessage() {
        return "unspecified";
    }
}
