#Building REST service with Spring WEB and Spring JDBC for SAP Portal
In this example I demonstrate how to create REST service and call data base on SAP Portal using Spring MVC and Spring JDBC

##Deploy to SAP Portal pure Java web application without NWDS
1. Prepare war file with your app
2. Login with sidadm on SAP NetWeaver WebAs server 
3. Go to following directory /usr/sap/SID/InstanceNo/j2ee/deployment/scripts
4. Find deploy.csh \ deploy.bat
5. Execute following command to deploy - it will show you how to execute command.
6. Example of deploy command: deploy username:password@host:port file_location