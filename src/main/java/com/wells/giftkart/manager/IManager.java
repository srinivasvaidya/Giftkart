package com.wells.giftkart.manager;

public interface IManager {
	
	public void getMQConnection();
	
	public int sendMessage();
	
	public boolean recieveMessage();

}
