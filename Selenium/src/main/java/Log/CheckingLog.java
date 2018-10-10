package Log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class CheckingLog 
{
	public static void main(String[] args)
	{
		Logger log= Logger.getLogger(CheckingLog.class);
		PropertyConfigurator.configure("log4j.properties");
		
		log.debug("code mistakes");
		log.info("in the main");
		log.error("not able to proceed next page");
	}
}
