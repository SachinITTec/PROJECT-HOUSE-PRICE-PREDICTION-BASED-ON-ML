package org.techhub.client;

import java.util.List;
import java.util.Scanner;

import org.techhub.model.CityModel;
import org.techhub.model.DistModel;
import org.techhub.model.StateModel;
import org.techhub.service.StateService;
import org.techhub.service.StateServiceImpl;


public class HousePricePredictionClientApp {
	public static void main(String[] args)
	{
		StateService stateservice=new StateServiceImpl();
		Scanner sobj=new Scanner(System.in);
		do
		{
			System.out.println("1:Add State");
			System.out.println("2:View All State");
			System.out.println("3:State Delete by Name");
			System.out.println("4:Update state by name");
			System.out.println("5:Dist Asscociate with state");
			System.out.println("6:View Dist Asscociate with state");
			System.out.println("7:Dist Delete By Name");
			System.out.println("8:Update Dist By Name");
			System.out.println("9:Add City");
			System.out.println("10:Delete City by name");
			System.out.println("11:Update City By name");
			System.out.println("12:View ALL the city");
			System.out.println("13:Add WardName:");
			System.out.println("14:Add New Aminities:");
		    System.out.println("Enter choice");
		    
		    
		    int choice=sobj.nextInt();
		 
		    switch(choice)
		    {
		    case 1:
		    	stateservice.displayAllStates();
		    	System.out.println("Enter state name");
		    	sobj.nextLine();
		    	String statename=sobj.nextLine();
		    	StateModel model=new StateModel(0,statename);
				boolean b=stateservice.isAddNewState(model);
				if(b)
				{
					System.out.println("State Added Successfully");
				}
				else
				{
					System.out.println("State not added ");
				}
				
				break;
		    case 2:
		    	List<StateModel> ViewStates=stateservice.viewAllState();
		    	if(ViewStates!=null)
		    	{
		    	for(StateModel a:ViewStates)
		    	{
		    	   System.out.println(a.getStateId()+"\t"+a.getStateName());
		    	}
		    	}
		    	else
		    	{
		    		System.out.println("List is Emplty!");
		    	}
				break;
		    case 3:
		    	stateservice.displayAllStates();
		    	System.out.println("Enter state name to delete");
		    	sobj.nextLine();
		        String statename1=sobj.nextLine();
		    	boolean b1=stateservice.isDeleteByName(statename1);
		    	
		    	if(b1)
		    	{
		    		System.out.println("Deleted!");
		    	}
		    	else
		    	{
		    		System.out.println("Some problem is there");
		    	}
		    	break;
		    case 4:
		    	stateservice.displayAllStates();
		    	System.out.println("Enter state name to update");
		    	sobj.nextLine();
		        String statename2=sobj.nextLine();
		        System.out.println("Enter Updated state name to update");
		        String statename3=sobj.nextLine();
		    	boolean b2=stateservice.isUpdateByName(statename2,statename3);
		    	if(b2)
		    	{
		    		System.out.println("updated!");
		    	}
		    	else
		    	{
		    		System.out.println("Some problem is there");
		    	}
		    	break;
		    	
		    case 5:
		    	System.out.println("Enter state name");
		    	sobj.nextLine();
		    	String statename4=sobj.nextLine();
		    	sobj.nextLine();
		    	System.out.println("Enter a dist name");
		    	String distname=sobj.nextLine();
		    	boolean b3=stateservice.isAddDistAdded(statename4,distname);
		    	if(b3)
		    	{
		    		System.out.println("Dist Added!");
		    	}
		    	else
		    	{
		    		System.out.println("Not Added!");
		    	}
		    	break;
		    	
		    case 6:
		    	System.out.println("Enter state name");
		    	sobj.nextLine();
		        String statename6=sobj.nextLine();
		        List<DistModel>DistView=stateservice.viewAllDist(statename6);
		        if(DistView!=null)
		        {
		           for(DistModel g:DistView)
		           {
		        	   System.out.println(g.getDistId()+"\t"+g.getDistname());
		           }
		        }
		        	
		    	
		    	break;
		    	
		    case 7:
		    	stateservice.displayAlldist();
		    	System.out.println("Enter dist name to delete");
		    	sobj.nextLine();
		        String dist=sobj.nextLine();
		    	boolean b7=stateservice.isDeleteDistByName(dist);
		    	if(b7)
		    	{
		    		System.out.println("Deleted!");
		    	}
		    	else
		    	{
		    		System.out.println("Some problem is there");
		    	}
		    	break;
		    
		    case 8:
		    	stateservice.displayAlldist();
		    	System.out.println("Enter Dist name to update");
		    	sobj.nextLine();
		        String dist1=sobj.nextLine();
		        System.out.println("Enter Updated Dist name to update");
		        String dist2=sobj.nextLine();
		    	boolean b8=stateservice.isUpdateDistByName(dist1,dist2);
		    	if(b8)
		    	{
		    		System.out.println("updated!");
		    	}
		    	else
		    	{
		    		System.out.println("Some problem is there");
		    	}
		    	break;
		    
		    case 9:
		    	System.out.println("Enter State Name ");
		    	sobj.nextLine();
		    	String city1=sobj.nextLine();
		    	System.out.println("Enter Dist Name");
		    	String city2=sobj.nextLine();
		    	System.out.println("Enter the city Name");
		    	String city3=sobj.nextLine();
		    	
		    	boolean b9=stateservice.isAddNewCity(city1,city2, city3);
		    	if(b9)
		    	{
		    		System.out.println("Added Successfully");
		    	}
		    	else
		    	{
		    		System.out.println("Some Problem is there");
		    	}
		    	break;
		    
		    case 10:
		    	stateservice.displayAllcity();
		    	System.out.println("Enter City Name ");
		    	sobj.nextLine();
		    	String city4=sobj.nextLine();
		    	boolean b10=stateservice.isDeleteCityByName(city4);
		    	if(b10)
		    	{
		    		System.out.println("The City Record Deleted Successfully");
		    	}
		    	else
		    	{
		    		System.out.println("Some Problem is there");
		    	}
		    	break;
		    	
		    case 11:
		    	stateservice.displayAllcity();
		    	System.out.println("Enter City you want to update");
		    	sobj.nextLine();
		    	String city5=sobj.nextLine();
		    	System.out.println("Enter the Updated City:");
		    	String city6=sobj.nextLine();
		    	boolean b11=stateservice.isUpdateCityByName(city5, city6);
		    	if(b11)
		    	{
		    		System.out.println("The City Name Updated Successfully");
		    	}
		    	else
		    	{
		    		System.out.println("The City Name Not Updated");
		    	}
		    	break;
		    	
		    case 12:
		    	System.out.println("Enter name of distname");
		    	sobj.nextLine();
		        String distname7=sobj.nextLine();
		        List<CityModel>CityView=stateservice.viewAllCity(distname7);
		        if(CityView!=null)
		        {
		           for(CityModel c:CityView)
		           {
		        	   System.out.println(c.getCityid()+"/t"+c.getCityname());
		           }
		        }
		    	break;
		    	
		    	
		    case 13:
		    	stateservice.displayAllcity();
		    	System.out.println("Enter city Name ");
		    	sobj.nextLine();
		    	String cityname=sobj.nextLine();
		    	
		    	System.out.println("Enter the ward Name");
		    	String wardname=sobj.nextLine();
		    	
		    	System.out.println("Enter the Pincode");
		    	int pincode=sobj.nextInt();

		    	
		    	
		    	boolean b12=stateservice.isAddNewWard(cityname,wardname,pincode);
		    	if(b12)
		    	{
		    		System.out.println("Added Successfully");
		    	}
		    	else
		    	{
		    		System.out.println("Some Problem is there");
		    	}
		    	break;

		      	
		    
		   
			default:
				System.out.println("Select correct choice!");
		    }
		}while(true);
		
	}
}
