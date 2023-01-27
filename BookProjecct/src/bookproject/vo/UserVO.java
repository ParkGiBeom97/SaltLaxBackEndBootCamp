package bookproject.vo;

public class UserVO {
	private String user_ID;
	private String user_PW;
	private String user_EM;
	private int user_point;

	public UserVO() {
		// TODO Auto-generated constructor stub
	}

	public UserVO(String user_ID, String user_PW, String user_EM, int user_point) {
		super();
		this.user_ID = user_ID;
		this.user_PW = user_PW;
		this.user_EM = user_EM;
		this.user_point = user_point;
	}

	public UserVO(String user_ID, String user_PW, String user_EM) {
		super();
		this.user_ID = user_ID;
		this.user_PW = user_PW;
		this.user_EM = user_EM;
	}

	public String getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}

	public String getUser_PW() {
		return user_PW;
	}

	public void setUser_PW(String user_PW) {
		this.user_PW = user_PW;
	}

	public String getUser_EM() {
		return user_EM;
	}

	public void setUser_EM(String user_EM) {
		this.user_EM = user_EM;
	}

	public int getUser_point() {
		return user_point;
	}

	public void setUser_point(int user_point) {
		this.user_point = user_point;
	}

	public UserVO(String user_ID, String user_PW) {
		super();
		this.user_ID = user_ID;
		this.user_PW = user_PW;
	}

}
