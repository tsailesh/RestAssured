package api.payload;

import java.util.Date;

public class bookingdates {

	private Date checkin;
	private Date checkout;

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date fakeDate1) {
		this.checkin = fakeDate1;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

}
