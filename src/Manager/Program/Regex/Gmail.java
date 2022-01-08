package Manager.Program.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gmail {
    private static  Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public Gmail() {
        pattern = java.util.regex.Pattern.compile(EMAIL_REGEX);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
