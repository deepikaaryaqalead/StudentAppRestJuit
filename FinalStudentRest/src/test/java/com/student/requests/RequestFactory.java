package com.student.requests;

import java.util.List;

import com.student.pojo.Student;
import com.student.tests.TestBase;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class RequestFactory  extends TestBase{
	RestClient restClient = new RestClient();

	@Step("Getting all the students")
	public Response getAllStudents() {
		
		Response response  = restClient.doGetRequest("/list");
		return response;

		
	}
	
	
	@Step("Create new student: {0} , {1} , {2} , {3}, {4}")
	public Response createANewStudent(String url, String firstName, String lastName, String email, String prog, List<String> courses) {
		Student body = new Student();
		body.setFirstName(firstName);
		body.setLastName(lastName);
		body.setEmail(email);
		body.setProgramme(prog);
		body.setCourses(courses);
		
		System.out.println("***Body in requestFactory **"+ body);
		Response response  = restClient.doPostRequest(url,body);
		return response;

		
	}
}
