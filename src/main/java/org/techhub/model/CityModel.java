package org.techhub.model;

public class CityModel {
	private int cityid;
	private String cityname;
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	
	public CityModel(int cityid,String cityname)
	{
		this.cityid=cityid;
		this.cityname=cityname;
	}
}
