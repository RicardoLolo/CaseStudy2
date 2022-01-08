package Manager.Program.CheckFail;

public class Id extends Exception {
    @Override
    public String getMessage() {
        return "Duplicate id";
    }
}
