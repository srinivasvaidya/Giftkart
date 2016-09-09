package com.wells.giftkart.manager;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.wells.giftkart.valueobject.Product;
import com.wells.giftkart.valueobject.ProductCategory;

public class MQManager implements IManager {

	public static ConnectionFactory factory=new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
	private Destination queue;
	private Connection connection;
	private Session session;
	private MessageProducer messageProducer;
	private MessageConsumer messageConsumer;
	private Message message;
	private ObjectMessage objectMessage;
	
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
	public int sendMessage()
	{
		System.out.println("in sendMessage() ");
			getMQConnection();
			
			ProductCategory prodcategory1=new ProductCategory();
			prodcategory1.setCatagoryname("Apparel");
			prodcategory1.setCategoryid(1);
			
			Product prod1=new Product();
			prod1.setProductId(101);
			prod1.setProdname("t-shirt");
			prod1.setPrice(700.00);
			prod1.setColour("blue");
			prod1.setCategory(prodcategory1);
			
			try {
				queue=session.createQueue("SAMPLEQUEUE");
				messageProducer=session.createProducer(queue);
				
				connection.start();
				objectMessage=session.createObjectMessage();
				objectMessage.setObject(prod1);
				messageProducer.send(objectMessage);
				
				//message=session.createTextMessage("Hi Hello from GiftKart web app");
				//messageProducer.send(message);
				
				System.out.println("sent Message of Product "+ prod1.getProdname() );
				
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return 0;
	}
	
	
	public boolean recieveMessage()
	{
		System.out.println("in recieveMessage() ");
		getMQConnection();
		
		try {
			queue=session.createQueue("SAMPLEQUEUE");
			messageConsumer=session.createConsumer(queue);
			
			connection.start();
			System.out.println("before recieve method");
			Message msg=messageConsumer.receive();
		System.out.println("message recived");
			if(msg instanceof ObjectMessage)
			{
				 Object object = ((ObjectMessage) msg).getObject();
				 Product p=(Product)object;
				 System.out.println("recieved Message of Product "+ p.getProdname());
			}
				messageConsumer.close();
			session.close();
			 connection.close(); 
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	public void init()
	{
		System.out.println("in init() ");
	}
}
