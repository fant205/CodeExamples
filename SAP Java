Шаблоны кода:




//method
		


//MultiTupleValue by values
	MdmValue[] values = mtv.getValues();
	for (int i = 0; i < values.length; i++) {
		TupleValue t = (TupleValue) values[i];
		...
	}
	

	
//SAP Logging:
	//log debug
	if(log.beDebug()) {
		log.debugT(method, "");
	}
	
	//log method
	String method = "loadAnalogs";
	boolean result = false;
	try {
		
		if (log.bePath()) {
			log.entering(method);
		}
		
		return result;
		
	} finally {
		if(log.bePath()){
			log.exiting(method);
		}
	}
	
	private static final Location sapLog = Location.getLocation(Location.getLocation("MtrSyncLog.log"));

	//mini
		public void sapLog(String msg, Object... args) {
			SimpleLogger.log(Severity.INFO, Category.APPLICATIONS, sapLog, "EoBe", String.format(msg, args));
		}


	//full
		public void logDebug(String method, String msg) {
			if (log.beDebug()) {
				log.debugT(method, msg);
			}
			SimpleLogger.log(Severity.INFO, Category.APPLICATIONS, loc, "MtrSync", msg);
		}
		
		
// regexp
		{
			String s = "S";
			String p = "[A-Z]";
			System.out.println(s.matches(p));
		}

		{
			String s = "SSS";
			String p = "[A-Z]+";
			System.out.println(s.matches(p));
		}
		
		{
			String s = "ВАПЕ";
			String p = "[А-Я]+";
			System.out.println(s.matches(p));
		}
		
		{
			String s = "фыва";
			String p = "[^А-Я]+";
			System.out.println(s.matches(p));
		}