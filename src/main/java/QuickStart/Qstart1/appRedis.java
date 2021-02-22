package QuickStart.Qstart1;

import redis.clients.jedis.Jedis;

public class appRedis {

	Jedis jedis ;
	
	appRedis()
	{
		jedis = new Jedis("192.168.40.130") ;
		//jedis = new Jedis("127.0.0.1") ;
		//jedis.auth("1111") ;
		
		jedis.set("clean", "clear") ;
		System.out.println("Result " + jedis.get("clean")) ;
	}
}
