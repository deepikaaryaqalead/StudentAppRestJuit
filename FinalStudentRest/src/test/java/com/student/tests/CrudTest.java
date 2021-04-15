package com.student.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.javafaker.Faker;
import com.student.requests.RequestFactory;
import com.student.specs.SpecificationFactory;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Story("This is a CRUD testing story")
public class CrudTest extends TestBase {

	RequestFactory requests = new RequestFactory();
	

	@Story("This is a CRUD testing story")
	@DisplayName(" New This is a test to get all the students from the database ")
	@Feature("New This is a test to get all students from database")
	@Test
	public void getStudentList() {
		
		
		requests.getAllStudents()
				.then()
				.spec(SpecificationFactory.getGenericResponseSpec())
				.statusCode(200);
		
		
	}
	
	@Story("This is a CRUD testing story")
	@DisplayName(" New This is a test to velidate creation of new student ")
	@Feature("New This is a test to velidate creation of new student")
	@Test	
	public void createNewStudent() {
		
		Faker fakeData = new Faker();
		String firstName = fakeData.name().firstName();
		String lastName = fakeData.name().lastName();
		String email = fakeData.internet().emailAddress();
		String prog ="computer science111";
		List<String> courses  = new ArrayList<String>();
		courses.add("C++");
		courses.add("Java");
		
		requests.createANewStudent("/", firstName, lastName, email, prog, courses)
				.then()
				.spec(SpecificationFactory.getGenericResponseSpec())
				.statusCode(201)
				.log()
				.all();
				
				
		
		
		
	}
	
}
