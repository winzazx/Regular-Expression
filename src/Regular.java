import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Regular   {
	public static void main(String[]args) {
		
	      String everything = getText("C:\\Users\\win-z\\Desktop\\Regular-Expression\\assets\\fradulent_emails.txt");
	      String[] contents = everything.split("From r\\s");

	      System.out.println("Total Email Found : "+(contents.length-1));

	      for(int i =1;i<contents.length;i++)
	      {System.out.println("----- Email No. "+i+" -----");
	      ////////////////////////Email-Sender/////////////////////////
	      String patternfrom = "From:.*";
	      
	      String from = rex(patternfrom,contents[i],false);
	      
	      String pattern_sender = "\\w\\S+@.*\\w";	     
	      String email =rex(pattern_sender,from,"Email-Sender");
	     
	      
	      String Pattern_name = "\".*\"";
	      rex(Pattern_name,from,"Name-Sender");
	      /////////////////////////////////////////////////////////////
	      
	      //////////////////////// Recipient //////////////////////////
	      String Pattern_to  = "To:.*";
	      String to = rex(Pattern_to,contents[i],false);
	      
	      String pattern_recipient  = "\\w\\S*@.*\\w";	     
	      rex(pattern_recipient ,to,"Recipient-Email");
	      
	      String pattern_recipient_name  = ":.*<";	     
	      rex(pattern_recipient_name ,to,"Recipient-Name");
	      /////////////////////////////////////////////////////////////
	      
	      //////////////////////////Date///////////////////////////////
	      String patterndate = "Date:.*";
	      String date = rex(patterndate,contents[i],false);
	      
	      String pattern_date_field = "\\d+\\s\\w+\\s\\d+";	     
	      rex(pattern_date_field,date,"Date-Send");
          /////////////////////////////////////////////////////////////
	      
	      //////////////////////Subject & Body ////////////////////////
	      String patternsubject = "Subject: .*";
	      String subject = rex(patternsubject,contents[i],false);
	      
	      String pattern_subject = "\\s.*";	     
	      rex(pattern_subject,subject,"Subject");
	      
	      String pattern_body = "Status:.+";
	      String body = rex(pattern_body,contents[i],true);
	      
	      String [] bodysplit = body.split("Status:");
	      bodysplit[1] = bodysplit[1].substring(3, bodysplit[1].length());
	      
	      count(pattern_body,bodysplit[1],true);
 
	      System.out.println("Body : "+ bodysplit[1]);
	      /////////////////////////////////////////////////////////////
	      
	      System.out.println("--------------------------------");
	      System.out.println("--------------------------------");
	      System.out.println();
	      
	     }
 }
	public static String rex(String pattern,String content,String key) {
		Pattern r = Pattern.compile(pattern,Pattern.DOTALL); //Patterm.CASE_INSENSITIVE
	     Matcher m = r.matcher(content);
	     if (m.find()) {
	         System.out.println(key+" : " + m.group(0) );

	     }else {
	    	 System.out.println(key+" : None");
         return "None";
	     }
	         
	     return m.group(0);
		
	}
	public static String rex(String pattern,String content,Boolean all) {
		Pattern r;
		if (all) {
		r = Pattern.compile(pattern,Pattern.DOTALL);
		}
		else {
		r = Pattern.compile(pattern);
		}
		
	     Matcher m = r.matcher(content);
	     if (m.find()) {
	    	 return m.group();
	     }else {
	    	 return "None";
	     }
		
	}
	
	
	
	
	
	
	public static void count(String pattern,String content,Boolean all) {
		Pattern r;
		if (all) {
		r = Pattern.compile("\\S*[a-zA-Z]\\s*",Pattern.DOTALL);
		}
		else {
		r = Pattern.compile(pattern);
		}
		ArrayList<String> temp = new ArrayList<String>();
	     Matcher m = r.matcher(content);
	     while(m.find())
	     { temp.add(m.group());
	    	 //System.out.println(m.group());
	     }
	  
	        for(String d:temp) {
	        	int count =0;
	            for (String f:temp) {
	            	if(d.equals(f)) {
	            		count++;
	            		
	            	}
	            }
	            System.out.println(d+count);
	            
	        }
	        /*
	        String country = getText("C:\\Users\\win-z\\Desktop\\Regular-Expression\\assets\\countries-list.txt");
	        String[] contents = country.split("\\r?\\n");
	        for (int i=0;i<content.length();i++) {
	        	String patterns = contents[i];
	        	rex(patterns,content,contents[i]);
	        }
	        */
	        
	}
	
	
	
	

	
	public static String getText (String path) {
		String line="";
		
		
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

