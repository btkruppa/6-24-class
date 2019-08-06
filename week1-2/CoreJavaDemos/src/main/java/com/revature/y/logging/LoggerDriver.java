package com.revature.y.logging;

import org.apache.log4j.Logger;

public class LoggerDriver {
	private static Logger log = Logger.getRootLogger();
	
	public static void main(String[] args) {
		log.trace("trace log is very granular");
		log.debug("debug log is not as granular as trace but not as system wide as info");
		log.info("info logs are not specific to code they are based on system events");
		log.warn("something odd happened but shouldn't be too bad");
		log.error("User experience is suffering to some degree and needs to be fixed");
		log.fatal("If the app is still running it probably shouldn't be and this needs immediate attention");
	}
}
