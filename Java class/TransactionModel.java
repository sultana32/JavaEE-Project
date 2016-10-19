package hasan.com.rashid;

import java.util.Date;


public class TransactionModel {
	
	private int id;
	private String type;
	private Date mydate;
	private int amount;
	// get and set methods
	public int getId() {
	    return id;
	}
	
	public void setId(int id) {
	    this.id = id;
	}
	
	public String getType() {
	    return type;
	}
	public void setType(String type) {
	    this.type = type;
	}
	public Date getDate() {
	    return mydate;
	}
	public void setDate(Date mydate) {
	    this.mydate = mydate;
	}
	public int getAmount() {
	    return amount;
	}
	public void setAmount(int amount) {
	    this.amount = amount;
	}

}

