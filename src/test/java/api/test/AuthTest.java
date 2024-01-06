package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.endpoints.BookingEndpoints;
import api.payload.Auth;
import io.restassured.response.Response;

public class AuthTest {

	Auth auth;

	@BeforeClass
	public void setUpAuth() {
		String un = "admin";
		String pw = "password123";
		auth = new Auth();
		auth.setUsername(un);
		auth.setPassword(pw);
	}

	@Test
	public void postAuth() {
		Response response = BookingEndpoints.authenticateUser(auth);
		// response.then().log().all();
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertTrue(responseBody.contains("\"token\":"), "Token not present");
	}

}
