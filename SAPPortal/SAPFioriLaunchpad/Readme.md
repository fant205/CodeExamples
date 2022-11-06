# Make custom SAPUI5 Module Plugin for SAP Fiori Launchpad on SAP Portal

1. Your make js file like 'TestPlugin.js'
2. Go to yout portal /irj
3. Go to Content Administration - Web Resource repository
4. Expand: Web Resources - FLP Extension Directory
5. Right click and Upload Resources
6. In the wizard you should upload your js file 'TestPlugin.js'
7. Go to Content Administration - Portal Content Management
8. Go to - portal_content/every_user/general/defaultFLPFrameworkContent/FLPFrameworkPage
9. Open Fiori Framework Page 
10. You see what contains Framework Page
11. Open FFP Resources (portal_content/every_user/general/defaultFLPFrameworkContent/FLPFrameworkPage/com.sap.portal.FLPResources) and got to the all properties
12. Fill properties:
	Custom Plugin URL: <url to your js file> (for example: /com.sap.portal.resourcerepository/repo/FLP_Extension_Directory/TestPlugin.js)
	Custom SAPUI5 Module Plugin Name: <your plugin name, which you setup in the js code like jQuery.sap.declare("my.custom.plugins.TestPlugin");> (for example value will be: my.custom.plugins.TestPlugin)
	SAPUI5 Library Source: <should be JAVA>
13. Go and check it