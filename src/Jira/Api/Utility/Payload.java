package Jira.Api.Utility;

public class Payload {

	public static String GetSessionBbody(){
		
	String	Jason="{ \"username\": \"amit.kumarr99\", "+
		    "\"password\": \"amit1234\" }";
                   
		return Jason;
	}
	
	public static String PostIssueBody(){
		String Jason="{"+
				 "\"fields\": {"+
				   "\"project\": {"+
				      "\"key\":\"STREAM\""+
				    "},"+
				    "\"summary\": \"payment options not displaying\","+
				    "\"description\": \"Creating this issue for paymnet options in soss place order process\","+
				    "\"issuetype\": {"+
				      "\"name\": \"Bug\""+
				    "}"+
				 
					 "}}";
		return Jason;
	}
	
	public static String PostIssueComment(){
		String Jason="{ \"body\": \"This is a test comment for onloine payment options issue in soss place order process \","+
				"\"visibility\": {"+
				"\"type\": \"role\","+
				"\"value\": \"Administrators\"}"+
				 "}";
		return Jason;
	}
	
	public static String UpdateIssueComment(){
		String Jason="{ \"body\": \"This is an updated comment for onloine payment options issue in soss place order process \","+
				"\"visibility\": {"+
				"\"type\": \"role\","+
				"\"value\": \"Administrators\"}"+
				 "}";
		return Jason;
	}
}
