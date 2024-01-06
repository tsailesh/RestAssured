package api.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.utils.URLEncodedUtils;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PayloadCreationTest {

	public class BookingDates {
		private LocalDate checkin;
		private LocalDate checkout;

		public BookingDates(LocalDate checkin, LocalDate checkout) {
			this.checkin = checkin;
			this.checkout = checkout;
		}

		public LocalDate getCheckin() {
			return checkin;
		}

		public void setCheckin(LocalDate checkin) {
			this.checkin = checkin;
		}

		public LocalDate getCheckout() {
			return checkout;
		}

		public void setCheckout(LocalDate checkout) {
			this.checkout = checkout;
		}

	}

	public class User {
		private String firstname;
		private String lastname;
		private BookingDates bookingDates;

		public User(String firstname, String lastname, BookingDates bookingDates) {
			this.firstname = firstname;
			this.lastname = lastname;
			this.bookingDates = bookingDates;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public BookingDates getBookingDates() {
			return bookingDates;
		}

		public void setBookingDates(BookingDates bookingDates) {
			this.bookingDates = bookingDates;
		}

	}

	@Test
	public void createAndPrintPayloads() throws JsonProcessingException, URISyntaxException {
		// Create a User object
		BookingDates bookingDates = new BookingDates(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 1, 7));
		User user = new User("John", "Doe", bookingDates);

		// Convert User object to JSON payload
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonPayload = objectMapper.writeValueAsString(user);
		System.out.println("JSON Payload:");
		System.out.println(jsonPayload);

		// Convert User object to XML payload (if needed)
		// For simplicity, let's use JSON only

		// Convert User object to URL-encoded payload
		List<org.apache.http.NameValuePair> params = new ArrayList<>();
		params.add(new org.apache.http.message.BasicNameValuePair("firstname", user.getFirstname()));
		params.add(new org.apache.http.message.BasicNameValuePair("lastname", user.getLastname()));
		params.add(new org.apache.http.message.BasicNameValuePair("bookingDates.checkin",
				user.getBookingDates().getCheckin().toString()));
		params.add(new org.apache.http.message.BasicNameValuePair("bookingDates.checkout",
				user.getBookingDates().getCheckout().toString()));

		String urlEncodedPayload = URLEncodedUtils.format(params, StandardCharsets.UTF_8);
		URI uri = new URI("https", "example.com", "/endpoint", urlEncodedPayload, null);
		System.out.println("\nURL Encoded Payload:");
		System.out.println(uri.toASCIIString());
	}
}
