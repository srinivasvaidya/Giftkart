package com.wells.giftkart.manager;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

import com.wells.giftkart.valueobject.Product;

public class MQClient implements MessageListener, IMQClient{
	
	public static final Logger logger=Logger.getLogger(MQClient.class);

	public static ConnectionFactory factory=new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
	private Destination queue;
	private Connection connection;
	private Session session;
	private MessageConsumer messageConsumer;

	
	public void getMQConnection()
	{		
		try {
			connection= factory.createConnection();
			
			session= connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			
	} catch (JMSException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	public boolean recieveMessage()
	{
		logger.info(" recieveMessage() started ");
		getMQConnection();
		
		try {  
			queue=session.createQueue("SAMPLEQUEUE");
			messageConsumer=session.createConsumer(queue);
			messageConsumer.setMessageListener(this);
			connection.start();
			
			messageConsumer.close();
			session.close();
			 connection.close(); 
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public void onMessage(Message msg) {
		logger.info("onMessage() started ");
		logger.debug("reccieved message is "+ msg.toString());
		logger.debug("recived object is of type "+ msg.getClass());
		logger.info("onMessage() end ");
	}
}
