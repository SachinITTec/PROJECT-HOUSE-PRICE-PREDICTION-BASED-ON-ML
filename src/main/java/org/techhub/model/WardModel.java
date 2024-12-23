package org.techhub.model;

public class WardModel {
	private int wardid;
	private int pincode;
	private String wardname;
	
	
	public WardModel(int wardid,String wardname,int pincode)
	{
		this.pincode=pincode;
		this.wardid=wardid;
		this.wardname=wardname;
	}
	
	public int getWardid() {
		return wardid;
	}
	public void setWardid(int wardid) {
		this.wardid = wardid;
	}
	public String getWardname() {
		return wardname;
	}
	public void setWardname(String wardname) {
		this.wardname = wardname;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
}
