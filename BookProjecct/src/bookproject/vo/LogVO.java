package bookproject.vo;

import java.util.*;

public class LogVO {

	private String bisbn;
	private String user_ID;
	private String btitle;
	private Date retalDay;
	private Date returnDay;

	public LogVO() {
		// TODO Auto-generated constructor stub
	}

	public LogVO(String bisbn, String user_ID, String btitle, Date retalDay) {
		super();
		this.bisbn = bisbn;
		this.user_ID = user_ID;
		this.btitle = btitle;
		this.retalDay = retalDay;
	}

	public LogVO(Date returnDay) {
		super();
		this.returnDay = returnDay;
	}

	public LogVO(String bisbn, String user_ID, String btitle, Date retalDay, Date returnDay) {
		super();
		this.bisbn = bisbn;
		this.user_ID = user_ID;
		this.btitle = btitle;
		this.retalDay = retalDay;
		this.returnDay = returnDay;
	}

	public LogVO(Date retalDay, Date returnDay) {
		super();
		this.retalDay = retalDay;
		this.returnDay = returnDay;
	}

	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public String getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public Date getRetalDay() {
		return retalDay;
	}

	public void setRetalDay(Date retalDay) {
		this.retalDay = retalDay;
	}

	public Date getReturnDay() {
		return returnDay;
	}

	public void setReturnDay(Date returnDay) {
		this.returnDay = returnDay;
	}

}
