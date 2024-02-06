package ec.edu.espe.viveresgabysoftwarekit.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mateo
 */
public class Validator {
    public static boolean validateLowercaseLetters(String input) {
        String pattern = "^[a-z]+$";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(input);
        return matcher.matches();
    }
}
