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
	
	
//sap log
	private static final Location sl = Location.getLocation(Location.getLocation("XXX.log"));

	//mini
		public void sapLog(String msg, Object... args) {
			SimpleLogger.log(Severity.INFO, Category.APPLICATIONS, sl, "XXX", String.format(msg, args));
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
		
//deploy without NWDS
1. Login with sidadm on SAP NetWeaver WebAs server 
2. Go to following directory /usr/sap/SID/InstanceNo/j2ee/deployment/scripts
3. Find deploy.csh \ deploy.bat
4. Execute following command to deploy - it will show you how to execute command.
5. Example of deploy command: deploy username:password@host:port file_location
	
	
	
//jpa sql
	SELECT COUNT(t) FROM MaterialEntity t WHERE t.id IN (SELECT u.material.id FROM AreasEntity u WHERE(u.name = :name1));
	
	
//	Добавление Software Component в NWDI
Создаем в SLD, назначаем dependencies для контекста BuildTime (если какие то компоненты не видны при добавлении, то возможно они появятся уже добавленными в компонент), открываем CMS вкладка Landscape Configurator. 
Там Domain Data 
нажимаем кнопку Change - кнопка Update CMS. 
Ждем. 
Далее заходим в Track Data, 
нажимаем  Change – нажимаем Sinchronize SC Dependencies – в появившемся окне видим компоненты, необходимо посмотреть подтянулись ли все DC и нажимаем кнопку, в названии которой есть SLD(она вторая слева). Для добавления нового SC нужно нажать кнопку Add SC и в ней выбрать свой SC и нажать кнопку «Save» другие не нажимать (всякие save and reimport).


//deploy JPA provider:
	- Put all jars to directory
	- Connect to NetWeaver using telnet <netweaver-host> 50008
	- execute command: add orpersistence
	- execute command: deploy_provider <your dir> -vendor org.hibernate -name hibernate4221 (<your dir > - should be inside istallution folder of sap ep)
	
// generate ear acrhetype java project
	mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-j2ee-simple -DarchetypeVersion=1.4