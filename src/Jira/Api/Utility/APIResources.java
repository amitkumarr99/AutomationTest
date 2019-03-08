package Jira.Api.Utility;

public class APIResources {
	
	public static String GetSessionIDResource(){
		 String res="/rest/auth/1/session";
		 return res;
	}
	public static String CreateIssueResource(){
		 String res="/rest/api/2/issue";
		 return res;
	}
	public static String CreateIssueCommentResource(){
		 String res="/rest/api/2/issue/10001/comment";
		 return res;
	}
}
