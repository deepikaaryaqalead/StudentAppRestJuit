package com.student.requests;

import com.student.specs.SpecificationFactory;
import com.student.tests.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestClient extends TestBase{

	public Response doGetRequest(String uri) {
		
		return RestAssured
				.given()
				.spec(SpecificationFactory.logPayloadResponseInfo())
				.when()
				.get(uri);
		
	}
	
	
public Response doPostRequest(String uri,  Object body) {
		
	System.out.println("****Base URL***"+RestAssured.baseURI);
	
	System.out.println("****BODY***"+ body);
		return RestAssured
				.given()
					.contentType(ContentType.JSON)
					.spec(SpecificationFactory.logPayloadResponseInfo())
				.when()
				 	.body(body)
				.post(uri);
		
	}
}
