package QuickStart.Qstart1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Recv {
	private final String QUEUE_NAME = "hello" ;
	
	ConnectionFactory factory ;
	Connection			connection ;
	Channel				channel ;
	
	Recv()
	{
		try
		{
			factory = new ConnectionFactory() ;
			factory.setHost("192.168.40.130");
			factory.setPort(5672) ;
			factory.setUsername("sgchun"); 
			factory.setPassword("ch1003");
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}
	
	public void qRecv()
	{
		try
		{
			connection = factory.newConnection();
			channel = connection.createChannel();
		
			System.out.println("[*] waiting for message To exit CTRL+C") ;
		
			DeliverCallback deliverCallback = (consumerTag, delivery) -> {
				String message = new String(delivery.getBody(), "UTF-8");
				System.out.println(" [x] Received '" + message + "'");
			};
        
			channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}
	}
}
