package hasan.com.rashid;

import java.sql.Timestamp;

public class UserEmailModel {
	private String userMail;
	private Timestamp forgetDate;  // time stamp when user requested pw change
	private int status;  // is the pw change request new or old
	
	// get and set methods
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public Timestamp getForgetDate() {
		return forgetDate;
	}
	public void setForgetDate(Timestamp forgetDate) {
		this.forgetDate = forgetDate;
	}
	
}
