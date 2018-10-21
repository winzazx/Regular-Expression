import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Looking {

   private static final String REGEX = "(foo)";
   private static final String INPUT = "foo";
   private static Pattern pattern;
   private static Matcher matcher;

   public static void main( String args[] ) {
      pattern = Pattern.compile(REGEX);
      matcher = pattern.matcher(INPUT);

      System.out.println("Current REGEX is: "+REGEX);
      System.out.println("Current INPUT is: "+INPUT);

      System.out.println("lookingAt(): "+matcher.lookingAt());
      System.out.println("matches(): "+matcher.matches());
      if (matcher.find()) {
          System.out.println("Found value0: " + matcher.group(0));
          System.out.println("Found value1: " + matcher.group(1));
          System.out.println("Found value2: " + matcher.group(2));
      } else {
          System.out.println("NO MATCH");
      }
   }
}