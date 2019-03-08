package Jira.Api.Utility;

import static io.restassured.RestAssured.given;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Configreader {

	public static Properties pro;

	public  Configreader(){

		try{
			pro=new Properties();
			FileInputStream fis= new FileInputStream("./Resource/Config.property");
			pro.load(fis);
			fis.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	
	//rahulonlinetutor@gmail.com

	public void SetProp(String Header, String value){
		
		try{
			 //pro=new Properties();
			 FileOutputStream fir = new FileOutputStream("./Resource/Config.property");
			 pro.store(fir,null);
			 pro.setProperty(Header, value);
			 fir.close();
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
	}
	
	public String GetSessionkey(){

		//RestAssured.baseURI=pro.getProperty("JiraHost");
		RestAssured.baseURI="http://localhost:8080";
		Response resp=	given().header("Content-Type","application/json").
				body(Payload.GetSessionBbody()).
				when().
				post(APIResources.GetSessionIDResource()).then().assertThat()
				.statusCode(200).and().extract().response();

		JsonPath js=CommonMethods.rawToJason(resp);
		String Sessionid=js.get("session.value");
		System.out.println("Session id is ===>"+Sessionid);
		return Sessionid;

	}
}