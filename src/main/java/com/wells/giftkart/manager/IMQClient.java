/**
 * 
 */
package com.wells.giftkart.manager;

import javax.jms.Message;

/**
 * @author u268407
 *
 */
public interface IMQClient {

	public void getMQConnection();
	public boolean recieveMessage();
	public void onMessage(Message msg);
}
