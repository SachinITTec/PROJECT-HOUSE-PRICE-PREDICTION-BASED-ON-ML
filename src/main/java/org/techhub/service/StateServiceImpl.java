package org.techhub.service;

import java.util.List;

import org.techhub.model.CityModel;
import org.techhub.model.DistModel;
import org.techhub.model.StateModel;
import org.techhub.repository.StateRepository;
import org.techhub.repository.StateRepositoryImpl;

public class StateServiceImpl implements StateService{

	StateRepository  stmtrepo=new StateRepositoryImpl();
	@Override
	public boolean isAddNewState(StateModel model) {
		
		return stmtrepo.isAddNewState(model);
	}
	
	public void displayAllStates() {
		 stmtrepo.displayAllStates();
	}
	
	public void displayAlldist()
	{
		stmtrepo.displayAlldist();
	}
	
	public void displayAllcity()
	{
		stmtrepo.displayAllcity();
	}
	@Override
	public List<StateModel> viewAllState() {
		return stmtrepo.viewAllState();
	}
	@Override
	public boolean isDeleteByName(String statename) {
		return stmtrepo.isDeleteByName(statename);
	}
	@Override
	public boolean isUpdateByName(String statename,String UpdatedName) {
		return stmtrepo.isUpdateByName(statename,UpdatedName);
	}
	@Override
	public boolean isAddDistAdded(String statename, String distname) {
		return stmtrepo.isAddDistAdded(statename, distname);
	}
	public List<DistModel> viewAllDist(String statename) {
		return stmtrepo.viewAllDist(statename);
	}
	public boolean isDeleteDistByName(String distname)
	{
		return stmtrepo.isDeleteDistByName(distname);
	}
	public boolean isUpdateDistByName(String distname,String UpdateDist)
	{
		return stmtrepo.isUpdateDistByName(distname, UpdateDist);
	}
	public boolean isAddNewCity(String statename,String distname,String cityname)
	{
		return stmtrepo.isAddNewCity(statename,distname,cityname);
	}
	public boolean isDeleteCityByName(String cityname) {
		return stmtrepo.isDeleteCityByName(cityname);
	}
	
	public boolean isUpdateCityByName(String cityname,String UpdatedCityName) {
		return stmtrepo.isUpdateCityByName(cityname, UpdatedCityName);
	}
	
	public List<CityModel> viewAllCity(String distname)
	{
		return stmtrepo.viewAllCity(distname);
	}
	

	@Override
	public boolean isAddNewWard(String cityname, String wardname, int pincode) {
		return stmtrepo.isAddNewWard(cityname, wardname, pincode);
	
	}
	
	

}




