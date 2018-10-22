package com.webservices.testscripts;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.webservices.methods.webservices;
import com.webservices.pojoclass.GetUserProfile_POJO;
import com.webservices.utils.EndPointUrl;
import com.webservices.utils.URL;

import bsh.classpath.BshClassPath.GeneratedClassSource;
import io.restassured.response.Response;

public class UserProfile_UnitTest {

	Response response;

	ArrayList<String> username;
	ArrayList<String> first_name;
	ArrayList<String> last_name;
	ArrayList<Integer> age;

	@BeforeClass
	public void setup() {
		username = new ArrayList<String>();
		username.add("SachinM");
		username.add("VinayK");
		username.add("PramodM");
		username.add("TarunK");

		first_name = new ArrayList<String>();
		first_name.add("Sachin");
		first_name.add("Vinay");
		first_name.add("Pramod");
		first_name.add("Tarun");

		last_name = new ArrayList<String>();
		last_name.add("Mannurkar");
		last_name.add("K");
		last_name.add("M");
		last_name.add("K");

		age = new ArrayList<Integer>();
		age.add(25);
		age.add(24);
		age.add(23);
		age.add(22);

	}

	/**
	 * 
	 * verifyGetUserProfile is to verify GET call()
	 */
	@Test
	public void verifyGetUserProfile() {
		Gson gson = new GsonBuilder().create();
		GetUserProfile_POJO[] getUserprofile; // Creating reference of POJO class
		String url = URL.fixedUrl + EndPointUrl.GET_PROFILE.getresourcepath();    //Gives the Complete Path
		response = webservices.GET(url);
		if (response.getStatusCode() == 200) {
			getUserprofile = gson.fromJson(response.getBody().asString(), GetUserProfile_POJO[].class);
			for (int i = 1; i <= getUserprofile.length; i++) {
				/**
				 * Assetions
				 */
				Assert.assertEquals(new Integer(i), Integer.valueOf(getUserprofile[i - 1].getId()));
				Assert.assertEquals(username.get(i - 1), getUserprofile[i - 1].getUsername());
				Assert.assertEquals(first_name.get(i - 1), getUserprofile[i - 1].getFirstName());
				Assert.assertEquals(last_name.get(i - 1), getUserprofile[i - 1].getLastName());
				Assert.assertEquals(age.get(i - 1), getUserprofile[i - 1].getAge());
			}
		}
	}

	/**
	 * VerifyDeletProfile is to verify DELETE call()
	 */
	@Test
	public void VerifyDeletProfile() {
		String url = URL.fixedUrl + EndPointUrl.DELETE_PROFILE.getresourcepath();
		response = webservices.DELETE(url);
		System.out.println(response.getBody().asString());
	}
}
