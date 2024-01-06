package api.payload;

import api.test.PayloadCreationTest.BookingDates;

public class User {

	private String firstname;
	private String lastname;
	private int totalprice;
	private boolean depositPaid;
	private BookingDates bookingDates;
	private String additionalNeeds;

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

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public boolean isDepositPaid() {
		return depositPaid;
	}

	public void setDepositPaid(boolean depositPaid) {
		this.depositPaid = depositPaid;
	}

	public BookingDates getBookingDates() {
		return bookingDates;
	}

	public void setBookingDates(BookingDates bookingDates) {
		this.bookingDates = bookingDates;
	}

	public String getAdditionalNeeds() {
		return additionalNeeds;
	}

	public void setAdditionalNeeds(String additionalNeeds) {
		this.additionalNeeds = additionalNeeds;
	}

}
