package api.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueBookingIDs {

	@Test
	public void printUniqueBookingIDs() {
		// Make the HTTP request and get the response
		Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking"); // Replace with your API
																								// endpoint

		// Extract booking IDs from the response and print unique IDs
		String jsonResponse = response.getBody().asString();
		System.out.println(jsonResponse);

		// Parse the JSON response and extract booking IDs
		String[] bookingIDs = Arrays.stream(jsonResponse.split("\"bookingid\"\\s*:\\s*")).skip(1) // Skip the first
																									// element (before
																									// the first booking
																									// ID)
				.map(s -> s.split(",")[0].replaceAll("[^0-9]", "")) // Extract numeric part as booking ID
				.toArray(String[]::new);

		// Filter out duplicates using a Set
		Set<String> uniqueBookingIDs = new HashSet<>(Arrays.asList(bookingIDs));

		// Print unique booking IDs
		// System.out.println("Unique Booking IDs:");
		// uniqueBookingIDs.forEach(System.out::println);
	}
}
