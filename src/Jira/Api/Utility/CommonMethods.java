package Jira.Api.Utility;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class CommonMethods {
  
	public static JsonPath rawToJason(Response resp){
		String Response=resp.asString();
		JsonPath jason=new JsonPath(Response);
		return jason;
	}
	
	public static XmlPath rawToXML(Response resp){
		String Response=resp.asString();
		XmlPath xml=new XmlPath(Response);
		return xml;
	}
}
