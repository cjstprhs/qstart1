package QuickStart.Qstart1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.*;
import java.util.concurrent.TimeoutException;


public class Send {
	private final static String QUEUE_NAME="hello" ; 

	ConnectionFactory 	factory ;
	Connection			connection ;
	Channel 			channel ;
	
	Send ()
	{
		factory = new ConnectionFactory() ;

		factory.setHost("192.168.40.130") ;
		factory.setPort(5672) ;
		factory.setUsername("sgchun"); 
		factory.setPassword("ch1003"); 
		
	}

	public void qSend()
	{
		try
		{
			connection = factory.newConnection() ;
			channel = connection.createChannel() ;
		
			for( int i = 0 ; i < 100 ; i++ )
			{
				channel.queueDeclare(QUEUE_NAME,false,false,false,null) ;
				String message = "Hello World" +(int)(Math.random() * 100) ;
				channel.basicPublish("", QUEUE_NAME, null, message.getBytes() ) ;
				System.out.println("[X] Set " + message + "") ;
				Thread.sleep(10) ;
			}
		}
		catch ( TimeoutException e )
		{
			e.printStackTrace(); 
		}
		catch ( IOException e ) 
		{
			e.printStackTrace();
		}
		catch( InterruptedException e )
		{
			e.printStackTrace();
		}

		return ;
	}
}
