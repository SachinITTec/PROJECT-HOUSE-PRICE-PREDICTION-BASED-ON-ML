package org.techhub.model;

public class StateModel {
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	private int stateId;
	private String stateName;
	

	public StateModel()
	{
	}
	
	public StateModel(int stateId,String stateName)
	{
       this.stateId=stateId;
       this.stateName=stateName;
	}
	
}
