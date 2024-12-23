package org.techhub.repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.techhub.model.CityModel;
import org.techhub.model.DistModel;
import org.techhub.model.StateModel;

public class StateRepositoryImpl extends DBSTATE  implements StateRepository {

	DBconfig config=DBconfig.getInstance();
	
	@Override
	public boolean isAddNewState(StateModel model) {
		// TODO Auto-generated method stub
		try
		{
			stmt=conn.prepareStatement("insert into  statemaster values('0',?)");
			stmt.setString(1,model.getStateName());
			int value=stmt.executeUpdate();
			return value>0?true:false;
			
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
		}
		return false;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	public void displayAllStates() {
	    try {
	        stmt = conn.prepareStatement("SELECT stateid, statename FROM statemaster");
	        rs = stmt.executeQuery();
	        System.out.println("Available States:");
	        while (rs.next()) {
	            System.out.println("ID: " + rs.getInt("stateid") + ", Name: " + rs.getString("statename"));
	        }
	    } catch (Exception e) {
	        System.out.println("Error: " + e);
	    }
	}

	
	public void displayAlldist() {
	    try {
	        stmt = conn.prepareStatement("SELECT distid, distname FROM distmaster");
	        rs = stmt.executeQuery();
	        System.out.println("Available States:");
	        while (rs.next()) {
	            System.out.println("ID: " + rs.getInt("distid") + ", Name: " + rs.getString("distname"));
	        }
	    } catch (Exception e) {
	        System.out.println("Error: " + e);
	    }
	}
	
	
	public void displayAllcity() {
	    try {
	        stmt = conn.prepareStatement("SELECT cityid, cityname FROM citymaster");
	        rs = stmt.executeQuery();
	        System.out.println("Available States:");
	        while (rs.next()) {
	            System.out.println("ID: " + rs.getInt("cityid") + ", Name: " + rs.getString("cityname"));
	        }
	    } catch (Exception e) {
	        System.out.println("Error: " + e);
	    }
	}

	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public List<StateModel> viewAllState() {
		List<StateModel> viewState=new ArrayList();
		try
		{
			stmt=conn.prepareStatement("select * from statemaster");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				StateModel model=new StateModel(rs.getInt(1),rs.getString(2));
				viewState.add(model);
			}
			return viewState;
		}catch(Exception e)
		{
           System.out.println("Error is"+e);
           return null;
		}
		
	}
	@Override
	public boolean isDeleteByName(String statename) {
		try
		{
			stmt=conn.prepareStatement("select stateid from statemaster where statename=?");
			stmt.setString(1,statename);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				
				stmt=conn.prepareStatement("delete from statemaster where stateid=?");
				stmt.setInt(1, rs.getInt(1));
				int value=stmt.executeUpdate();
				return value>0?true:null;
			}
		}catch(Exception e)
		{
          System.out.println("Error is"+e);			
		}
		
		return false;
	}
	@Override
	public boolean isUpdateByName(String statename,String UpdatedName) {
		try
		{
			stmt=conn.prepareStatement("select stateid from statemaster where statename=?");
			stmt.setString(1,statename);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				
				stmt=conn.prepareStatement("update statemaster set statename=? where stateid=?");
				
				stmt.setString(1,UpdatedName);
				stmt.setInt(2, rs.getInt("stateid"));
				int value=stmt.executeUpdate();
				return value>0?true:null;
			}
		}catch(Exception e)
		{
          System.out.println("Error is"+e);			
		}
		
		return false;
	}
	@Override
	public boolean isAddDistAdded(String statename, String distname) {
		try
		{
			cstmt=conn.prepareCall("{call saveDist(?,?)}");
			cstmt.setString(1, statename);
			cstmt.setString(2, distname);
			
			boolean b=cstmt.execute();
			return !b;
			
		}
		catch(Exception e)
		{
			System.out.println("Error is"+e);
			return false;
		}
	}
	@Override
	public List<DistModel> viewAllDist(String statename) {
		try
		{
			List<DistModel>viewAllDist=new ArrayList();
			cstmt=conn.prepareCall("{call getDist(?)}");
			cstmt.setString(1, statename);
			rs=cstmt.executeQuery();
			while(rs.next())
			{
			   	DistModel model=new DistModel(rs.getInt(1),rs.getString(2));
			   	viewAllDist.add(model);
		    }
			return viewAllDist;
		}
		catch(Exception e)
		{
			System.out.println("Error is"+e);
		}
		return null;
	}
	
	public boolean isDeleteDistByName(String distname) {
		try
		{
			stmt=conn.prepareStatement("select distid from distmaster where distname=?");
			stmt.setString(1,distname);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				
				stmt=conn.prepareStatement("delete from distmaster where distid=?");
				stmt.setInt(1, rs.getInt(1));
				int value=stmt.executeUpdate();
				return value>0?true:null;
			}
		}catch(Exception e)
		{
          System.out.println("Error is"+e);			
		}
		
		return false;
	}
	
	public boolean isUpdateDistByName(String distname,String UpdateDist)
	{
		try
		{
			stmt=conn.prepareStatement("select distid from distmaster where distname=?");
			stmt.setString(1,distname);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				
				stmt=conn.prepareStatement("update distmaster set distname=? where distid=?");
				
				stmt.setString(1,UpdateDist);
				stmt.setInt(2, rs.getInt("distid"));
				int value=stmt.executeUpdate();
				return value>0?true:null;
			}
		}catch(Exception e)
		{
          System.out.println("Error is"+e);			
		}
		
		return false;
	}
	
	public boolean isAddNewCity(String statename,String distname,String cityname) {
		try
		{
			cstmt=conn.prepareCall("{call citycall(?,?,?)}");
			cstmt.setString(1, statename);
			cstmt.setString(2, distname);
			cstmt.setString(3, cityname);
			boolean b=cstmt.execute();
			return !b;
			
		}
		catch(Exception e)
		{
			System.out.println("Error is"+e);
			return false;
		}
	}
	
	public boolean isDeleteCityByName(String cityname)
	{
		try
		{
			stmt=conn.prepareStatement("select cityid from citymaster where cityname=?");
			stmt.setString(1,cityname);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				
				stmt=conn.prepareStatement("delete from citymaster where cityid=?");
				stmt.setInt(1, rs.getInt(1));
				int value=stmt.executeUpdate();
				return value>0?true:null;
			}
		}catch(Exception e)
		{
          System.out.println("Error is"+e);			
		}
		
		return false;
	}
	
	public boolean isUpdateCityByName(String cityname,String UpdatedCityName) {
		try
		{
			stmt=conn.prepareStatement("select cityid from citymaster where cityname=?");
			stmt.setString(1,cityname);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				
				stmt=conn.prepareStatement("update citymaster set cityname=? where cityid=?");
				
				stmt.setString(1,UpdatedCityName);
				stmt.setInt(2, rs.getInt("cityid"));
				int value=stmt.executeUpdate();
				return value>0?true:null;
			}
		}catch(Exception e)
		{
          System.out.println("Error is"+e);			
		}
		
		return false;
	}
	
	public List<CityModel> viewAllCity(String distname) {
		try
		{
			
			List<CityModel>viewAllcity=new ArrayList();
			cstmt=conn.prepareCall("{call viewcity(?)}");
			cstmt.setString(1, distname);
			rs=cstmt.executeQuery();
			while(rs.next())
			{
			   	CityModel model=new CityModel(rs.getInt(1),rs.getString(2));
			   	viewAllcity.add(model);
		    }
			return viewAllcity;
		}
		catch(Exception e)
		{
			System.out.println("Error is"+e);
		}
		return null;
	}
	
	public boolean isAddNewWard(String cityname,String wardname,int pincode) {
		try
		{
			cstmt=conn.prepareCall("{call callwardpro(?,?,?)}");
			cstmt.setString(1, cityname);
			cstmt.setString(2, wardname);
			cstmt.setInt(3, pincode);
			boolean b=cstmt.execute();
			return !b;
			
		}
		catch(Exception e)
		{
			System.out.println("Error is"+e);
			return false;
		}
	
	
}
	
	
}