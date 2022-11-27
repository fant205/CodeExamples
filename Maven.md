Maven:
	Команды:
		mvn clean - чистка в проекте всего что было сгенерировано
		mvn package - прогон билда, тестов, подтягивание зависимостей, если указал в pom.xml, паковка в jar файл
		mvn install - все что и package и еще копирование в локальный репозиторий сформированного jar, и можно будет в других проектах локально юзать этот jar как либу через dependencies
		mvn dependencies:tree - покажет в текущем проекте дерево зависимостей

	Репозитории:
		Local - локальный - на компе репозиторий, находится по адресу ${userhome}/.m2 (папка .m2 скрытая). Для винды это Documents/Users, для мак или убунту корневая папка юзера
		Central - Центральный (https://mvnrepository.com), если в локальном не нашли, ищем в центральном, если нашли, то копирование в локальный, если не нашли, то идем в remote
		Remote - Удаленный, это репозиторий в какой-либо компании, внутри нее, и там есть какие-то свои наработки. Можно в maven настроить как Remote какой то сервер компании, и maven будет работать с ним. Если нашли в remote, то копирование в локальный, если нет, то ошибка что такой библиотеки нет
	
	
	Полезные зависимости:
		//Дает готовые решения для частых простых задач
		<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-lang3</artifactId>
			<version>3.12.0</version>
		</dependency>

		//как и apache дает много решений для простых вещей (кеш, RateLimiter, если нужно сделать что бы был 5 запросов в секунду и не больше)
		<!-- https://mvnrepository.com/artifact/com.google.guava/guava -->
		<dependency>
			<groupId>com.google.guava</groupId>
			<artifactId>guava</artifactId>
			<version>31.0.1-jre</version>
		</dependency>

	settings.xml:
		${maven.home}/conf/settings.xml - maven home можно узнать командой mvn -v
		${user.home}/.m2/settings.xml




mvn package - сделать jar или war, в зависимости что указано в pom.xml
mvn tomcat:run -запуск встроенного tomcat
mvn dependency:tree - вывод дерева зависимостей
mvn dependency:analyze -DignoreNonCompile - вывод не используемых зависимостей
mvn clean package tomcat:run --пакетный запуск команд
	
mvn --version - вывод версии Maven:
	make current maven 3.8.4:
	xport M2_HOME=/usr/local/apache-maven/apache-maven-3.8.4
	export M2=$M2_HOME/bin
	export MAVEN_OPTS="-Xms256m -Xmx512m"
	export PATH=$M2:$PATH          
	source ~/.profile
	



Управелние зависимостями:
	Пример как указать конкретный jar библиотеки на своем ПК:
		Вариант 1:
		<dependency>
			<groupId>com.microsoft.sqlserver</groupId>
			<artifactId>sqljdbc</artifactId>
			<version>6.0</version>
			<scope>system</scope>
			<systemPath>${basedir}/lib/com.microsoft.sqlserver/sqljdbc/6.0/sqljdbc42.jar</systemPath>
			<optional>true</optional>
		</dependency>
		
		Вариант 2:
			Добавляем в свой локальный репозиторий Maven свой jar:
				mvn install:install-file -Dfile=/C/Work/JARs/tc~je~usermanagement~api.jar -DgroupId=sap.com -DartifactId=ume.api -Dversion=1.0 -Dpackaging=jar -DgeneratePom=true
			Добавляем в pom.xml зависимость как обычно:
				<dependency>
					<groupId>sap.com</groupId>
					<artifactId>ume.api</artifactId>
					<version>1.0</version>
				</dependency>