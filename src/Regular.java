import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Regular {
	public static void main(String[]args) {
		

		
	      String everything = getText();
	      String[] contents = everything.split("From r");
	      String temp="";
	      
	      
	      System.out.println("Total Email Found : "+(contents.length-1));

	      for(int i =1;i<contents.length;i++)
	      {System.out.println("----- Email No. "+i+" -----");
	      String patternfrom = "From:.*";
	      String from = rex(patternfrom,contents[i]);
	      
	      String pattern_sender = "\\w\\S*@.*\\w";	     
	      rex(pattern_sender,from,"Email-Sender");
	      
	      String Pattern_name = "\".*\"";
	      rex(Pattern_name,from,"Name-Sender");
	      
	      String Pattern_to  = "To:.*";
	      String to = rex(Pattern_to,contents[i]);
	      
	      String pattern_recipient  = "\\w\\S*@.*\\w";	     
	      rex(pattern_recipient ,to,"Recipient-Email");
	      
	      String pattern_recipient_name  = ":.*<";	     
	      rex(pattern_recipient_name ,to,"Recipient-Name");
	      
	      String patterndate = "Date:.*";
	      String date = rex(patterndate,contents[i]);
	      
	      String pattern_date_field = "\\d+\\s\\w+\\s\\d+";	     
	      rex(pattern_date_field,date,"Date-Send");
	      
	      
	      String patternsubject = "Subject: .*";
	      String subject = rex(patternsubject,contents[i]);
	      
	      String pattern_subject = "\\s.*";	     
	      rex(pattern_subject,subject,"Subject");
	      
	      String pattern_body = "Status:.+";
	      String body = rex(pattern_body,contents[i],"Body");
	      
	      
	      
	      System.out.println();
	     }
 }
	public static String rex(String pattern,String content,String key) {
		Pattern r = Pattern.compile(pattern,Pattern.DOTALL);
	     Matcher m = r.matcher(content);
	     if (m.find()) {
	         System.out.println(key+" : " + m.group(0) );

	     }else {
	    	 System.out.println(key+" : None");
         return "None";
	     }
	         
	     return m.group(0);
		
	}
	public static String rex(String pattern,String content) {
		Pattern r = Pattern.compile(pattern);
	     Matcher m = r.matcher(content);
	     m.find();
	         
	     return m.group(0);
		
	}
	
	
	public static String getText () {
		String line="";
		String path = "C:\\Users\\Winza\\eclipse-workspace\\Regular-Expression\\assets\\test_emails.txt";
		File file = new File(path);
		StringBuilder sb = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));	
			
			while ((line = br.readLine()) != null) {
				 sb.append(line);
			     sb.append(System.lineSeparator());
			}
			br.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String text = sb.toString();
        return text;
    }
	
	
	
}

