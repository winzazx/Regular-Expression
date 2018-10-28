import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Group {

    public static void main(String args[]) {
        String line = "2016-02-11"; 
        String pattern = "(\\d{4})-(\\d{2})-(\\d{2})";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);

        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }
    }

}