package api.test;

import java.time.LocalDate;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import api.endpoints.BookingEndpoints;
import api.payload.User;
import api.payload.bookingdates;
import io.restassured.response.Response;

public class UserTest {

	Faker faker;
	User userpayload;
	bookingdates bookingdate;

	@BeforeClass
	public void setUpUserData() {
		faker = new Faker();
		userpayload = new User();
		bookingdate = new bookingdates();
		Date date1 = new Date();
	Date date2 = date1.
		Date date1 = faker.date().birthday().toInstant().atZone(java.time.ZoneId.systemDefault())
				.toLocalDate();
		LocalDate fakeDate2 = fakeDate1.plusDays(2);
		bookingdate.setCheckin(new Date());
		bookingdate.setCheckout(setCh);
		userpayload.setFirstname(faker.name().firstName());
		userpayload.setLastname(faker.name().firstName());
		userpayload.setTotalprice(faker.idNumber().hashCode());
		userpayload.setDepositPaid(faker.bool().bool());
		userpayload.setBookingDates(bookingdate);
		userpayload.setAdditionalNeeds(faker.programmingLanguage().name());
		System.out.println(userpayload);
	}

	@Test(priority = 1)
	public void getAllBookings() {
		Response response = BookingEndpoints.getAllBookingId();
		Object[] responseArray = response.jsonPath().getObject("bookingid", Object[].class);
		/*
		 * for (Object res : responseArray) { anyBookingId = res.toString(); break; }
		 */

		Assert.assertEquals(response.getStatusCode(), 200, "Status code not 200 in getAllBookingsId");
		Assert.assertNotNull(responseArray, "Response array is null");
		Assert.assertTrue(responseArray.length > 0, "Response array is empty");
	}

	@Test(priority = 2)
	public void getBookingById() {
		int id = 10;
		Response response = BookingEndpoints.getBookingIdById(Integer.valueOf(id));
		String jsonResponse = response.getBody().asString();
		Assert.assertEquals(response.getStatusCode(), 200, "Status code not 200 in getAllBookingsId");
		Assert.assertTrue(jsonResponse.contains("firstname"));
		Assert.assertTrue(jsonResponse.contains("lastname"));
		Assert.assertTrue(jsonResponse.contains("totalprice"));
		Assert.assertTrue(jsonResponse.contains("depositpaid"));
		Assert.assertTrue(jsonResponse.contains("checkin"));
		Assert.assertTrue(jsonResponse.contains("checkout"));
		Assert.assertTrue(jsonResponse.contains("additionalneeds"));

	}

	// @Test(priority = 3)
	public void getBookingByName() {
		Response response = BookingEndpoints.getBookingIdByName("john", "Smith");
		String res = response.getBody().asString();
		System.out.println(res);
		Assert.assertEquals(response.getStatusCode(), 200, "Status code not 200 in getAllBookingsByName");

	}

	@Test(priority = 4)
	public void getBookingByFirstName() {
		Response response = BookingEndpoints.getBookingIdByFirstName("John");
		response.then().log().all();
		String res = response.getBody().asString();
		Assert.assertEquals(response.getStatusCode(), 200, "Status code not 200 in getAllBookingsByName");
	}

	@Test(priority = 5)
	public void createBookingJson() throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonPayload = objectMapper.writeValueAsString(userpayload);
		System.err.println(jsonPayload);
		Response response = BookingEndpoints.createBookingJSON(userpayload);
		// response.then().log().all();
		String res = response.getBody().asString();
		System.out.println(res);
		Assert.assertEquals(response.getStatusCode(), 200, "Status code not 200 in getAllBookingsByName");
	}

}
