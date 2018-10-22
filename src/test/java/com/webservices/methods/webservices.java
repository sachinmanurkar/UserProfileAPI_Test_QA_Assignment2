package com.webservices.methods;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class webservices {

	public static Response POST(String urI, String JSON) {

		RestAssured.reset();
		RequestSpecification requestspecification = RestAssured.given().body(JSON);
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.post("/profile/new");
		return response;

	}

	public static Response GET(String urI) {
		RestAssured.reset();
		RequestSpecification requestspecification = RestAssured.given();
		Response response = requestspecification.get("/profiles");
		return response;

	}

	public static Response PUT(String urI, String JSON) {
		RestAssured.reset();
		RequestSpecification requestspecification = RestAssured.given().body(JSON);
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.put("/profile/update");
		return response;

	}

	public static Response DELETE(String urI) {
		RestAssured.reset();
		RequestSpecification requestspecification = RestAssured.given();
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.delete("profile/delete");
		return response;
	}
}
