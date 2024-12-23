package org.techhub.model;

public class DistModel {

	
		// TODO Auto-generated method stub
		private int distId;
		private String distname;
		public int getDistId() {
			return distId;
		}
		public void setDistId(int distId) {
			this.distId = distId;
		}
		public String getDistname() {
			return distname;
		}
		public void setDistname(String distname) {
			this.distname = distname;
		}
		public DistModel(int distid,String distname)
		{
			this.distId=distid;
			this.distname=distname;
		}
		

}
