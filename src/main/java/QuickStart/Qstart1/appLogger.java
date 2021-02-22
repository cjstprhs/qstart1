package QuickStart.Qstart1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class appLogger {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	appLogger()
	{
		
	}
	
	public void outLog(String msgStr)
	{
		if( logger.isInfoEnabled())
		{
			logger.info(msgStr);
		}
	}
}
