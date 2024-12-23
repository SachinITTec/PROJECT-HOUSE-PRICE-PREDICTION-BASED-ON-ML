package org.techhub.repository;

import java.util.List;

import org.techhub.model.CityModel;
import org.techhub.model.DistModel;
import org.techhub.model.StateModel;

public interface StateRepository {
	public boolean isAddNewState(StateModel model);
	public void displayAllStates();
	public void displayAlldist();
	public void displayAllcity();
	public List<StateModel> viewAllState();
	public boolean isDeleteByName(String statename);
	public boolean isUpdateByName(String statename,String UpdatedName);
	public boolean isAddDistAdded(String statename,String distname);
	public List<DistModel> viewAllDist(String statename);
	public boolean isDeleteDistByName(String distname);
	public boolean isUpdateDistByName(String distname,String UpdatedDist);
	public boolean isAddNewCity(String statename,String distname,String cityname);
	public boolean isDeleteCityByName(String cityname);
	public boolean isUpdateCityByName(String cityname,String UpdatedCityName);
	public List<CityModel> viewAllCity(String distname);
	public boolean isAddNewWard(String cityname,String wardname,int pincode);
}
