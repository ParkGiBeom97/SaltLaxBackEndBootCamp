package bookproject.vo;

import java.util.*;

public class RentalVO {
	private String bisbn;
	private String btitle;
	private String user_ID;
	private Date rentalDay;

	public RentalVO() {
		// TODO Auto-generated constructor stub
	}

	public RentalVO(String bisbn, String btitle, String user_ID, Date rentalDay) {
		super();
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.user_ID = user_ID;
		this.rentalDay = rentalDay;
	}

	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}

	public Date getRentalDay() {
		return rentalDay;
	}

	public void setRentalDay(java.sql.Date rentalDay) {
		this.rentalDay = rentalDay;
	}

}
