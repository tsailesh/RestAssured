package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.Auth;
import api.payload.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

public class BookingEndpoints extends User {

	public static Response authenticateUser(Auth auth) {
		Response response = given().contentType(ContentType.JSON) // Set content type as JSON
				.body(auth) // Set the request body
				.when().post(Routes.authUrl); // API endpoint
		return response;
	}

	public static Response getAllBookingId() {
		Response response = RestAssured.given().when().get(Routes.cuUrl);
		return response;
	}

	public static Response getBookingIdByName(String fname, String lname) {
		Response response = RestAssured.given().queryParam("firstname", fname).queryParam("lastname", lname).when()
				.get(Routes.cuUrl);
		return response;
	}

	public static Response getBookingIdByFirstName(String fname) {
		Response response = RestAssured.given().queryParam("firstname", fname).when().get(Routes.cuUrl);
		return response;
	}

	public static Response getBookingIdByCheckinAndCheckput(User user) {
		Response response = RestAssured.given().queryParam("checkin", user.getBookingDates().getCheckin())
				.queryParam("checkout", user.getBookingDates().getCheckout()).when().get(Routes.cuUrl);
		return response;
	}

	public static Response getBookingIdById(int id) {
		Response response = RestAssured.given().pathParam("id", id).when().get(Routes.urlById);
		return response;
	}

	public static Response createBookingJSON(User user) {
		Response response = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body(user).when()
				.post(Routes.cuUrl);
		return response;
	}

	public static Response createBookingXML(User user) {
		Response response = RestAssured.given().contentType(ContentType.XML).body(user).when().post(Routes.cuUrl);
		return response;
	}

	public static Response createBookingURLEncoded(User user) {
		Response response = RestAssured.given().contentType(ContentType.URLENC).body(user).when().post(Routes.cuUrl);
		return response;
	}

	public static Response updateBooking(User user) {
		Response response = RestAssured.given().contentType(ContentType.JSON).body(user).when().put(Routes.urlById);

		return response;
	}

	public static Response updateBookingPartially(User user) {
		Response response = RestAssured.given().contentType(ContentType.JSON).body(user).when().patch(Routes.urlById);
		return response;
	}

	public static Response deleteById() {
		int id = 2;
		Response response = RestAssured.given().pathParam("id", id).when().delete(Routes.deleteUrl);
		return response;
	}
}
