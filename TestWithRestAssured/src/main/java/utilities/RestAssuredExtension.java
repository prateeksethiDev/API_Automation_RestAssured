package utilities;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class RestAssuredExtension {
	
	static RequestSpecification request;

	public RestAssuredExtension() {
		//Arrange		
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri("http://localhost:3000");
		builder.setContentType(ContentType.JSON);
		RequestSpecification requestSpec=builder.build();
		
		request=RestAssured.given().spec(requestSpec);		
	}
	
	public static void getOpsWithPathParam(String url,Map<String,String>pathParams)  {
		request.pathParams(pathParams);
		
		try {
			request.get(new URI(url));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public static ResponseOptions<Response> getOps(String url)  {
		try {
			return request.get(new URI(url));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  null;
	}
	
	public static ResponseOptions<Response> postOpsWithBodyAndPathParam(String url, Map<String,String>pathParams, Map<String,String> postBody) {		
		request.pathParams(pathParams);
		request.body(postBody);
		
			return request.post(url);
	}
}