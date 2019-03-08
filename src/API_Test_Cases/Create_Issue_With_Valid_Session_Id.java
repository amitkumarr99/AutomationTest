package API_Test_Cases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import Jira.Api.Utility.APIResources;
import Jira.Api.Utility.CommonMethods;
import Jira.Api.Utility.Configreader;
import Jira.Api.Utility.Payload;

public class Create_Issue_With_Valid_Session_Id {
	
	Configreader config;

	@BeforeTest
	public void setup(){
		config=new Configreader();
		
	}
	
	//@Test( description="Create new issue/bug in Jira Using Post Request")
	
	public void  Create_Issue_With_Valid_Session_ID(){
		
		Response resp=given().header("Content-Type","application/json").
		header("Cookie","JSESSIONID="+config.GetSessionkey()).
		body(Payload.PostIssueBody()).when().
		post(APIResources.CreateIssueResource()).then().assertThat().
		statusCode(201).extract().response();
		
		JsonPath js=CommonMethods.rawToJason(resp);
		String IssueId=js.get("id");
		System.out.println("Create new issue with Post and Issue Id is===>"+IssueId);
		config.SetProp("IssueID", IssueId);
		
		}
	
	//@Test( description="Create/Add comment to newly created issue/bug in Jira Using Post Request")
	
	public void Add_Comment_to_Created_Issue(){
		
		Response resp=given().header("Content-Type","application/json").
				header("Cookie","JSESSIONID="+config.GetSessionkey()).
				
				body(Payload.PostIssueComment()).when().
				post("/rest/api/2/issue/10103/comment").then().assertThat().
				statusCode(201).extract().response();
		
				JsonPath js=CommonMethods.rawToJason(resp);
				String CommentId=js.get("id");
				String Issuebody=js.get("body");
				System.out.println("Add comment to new issue and comment Id is===>"+CommentId);
				System.out.println("Add comment to new issue and comment body is===>"+Issuebody);
				
				}	
	
	//@Test( description="Update existing/ added comment to newly created issue/bug in Jira Using Put Request")
	
public void Update_Comment_to_Created_Issue(){
		
		Response resp=given().header("Content-Type","application/json").
				header("Cookie","JSESSIONID="+config.GetSessionkey()).
				
				body(Payload.UpdateIssueComment()).when().
				put("rest/api/2/issue/10103/comment/10004").then().assertThat().
				statusCode(200).extract().response();
		
				JsonPath js=CommonMethods.rawToJason(resp);
				String update_commentId=js.get("id");
				String update_Issuebody=js.get("body");
				System.out.println("Update issue comment with Put and  comment Id is===>"+update_commentId);
				System.out.println("Update issue comment with Put and  comment Id is===>"+update_Issuebody);
	}
	
	//@Test( description="Get the newly created Issue/bug in Jira using Get request")
	
	public void Get_Newly_Created_Issue(){
		
	Response resp=	given().
		header("Cookie","JSESSIONID="+config.GetSessionkey()).
		when().
		get("/rest/api/2/issue/10103").then().assertThat().statusCode(200).
		extract().response();
		
		JsonPath js=CommonMethods.rawToJason(resp);
		 String GetIssueID= js.get("id");
		 String GetIssuekey=js.get("key");
		 
		  config.SetProp("IssueID", GetIssueID);
		  config.SetProp("IssueKey", GetIssuekey);
		  
		  System.out.println("Get issue request and issue id is===>"+GetIssueID);
		  System.out.println("Get issue request and issue key is===>"+GetIssuekey);
		  
	}
		@Test(description="Delete the newly created Issue/bug in Jira using delete request") 
	public void Delete_Created_Issue(){
		
	Response resp=	given().
		header("Cookie","JSESSIONID="+config.GetSessionkey()).
		when().
		delete("/rest/api/2/issue/10103").then().assertThat().statusCode(204).
		extract().response(); 
	String Delres=resp.asString();
	System.out.println(Delres);
	}
}
