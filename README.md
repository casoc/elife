##Description

  This application is a Java EE Demo, I want this demo can guide other people to learning use below framework to build a new project.

##Technology stack
 
 1. Spring Framework 3.2.8 (MVC\Security)
 2. Hibernate 3
 3. FreeMarker
 4. LambdJ
 5. Liquibase
 6. Selenium webdriver
 7. concordion
 8. JNDI
 
##How to use?	
1. create the databases named 'web_demo' and 'web_demo_test'
2. change the database config in

		build/environment/develop/jetty_env.xml

3. use mvn compile code
4. then you can run the server use command

		mvn jetty:run
		
notes:
 
 * application default use develop environment, if you want use other environment, you can change **env** in pom.xml
 * if you want create your own environment, you can create a new directory under environment and copy **jetty_env.xml** and modify it