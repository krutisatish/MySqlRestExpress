A Minimal RestExpress Server + Mysql Custom Client
=========================

Uses the template RestExpress project and adds features to query HBase.

To run the project:
	mvn clean package exec:java

To create a project deployable assembly (zip file):            
	mvn clean package            
	mvn assembly:single

Main - src/main/java/com/kogentix/rest      
Client - src/main/java/com/kogentix/client/        
RestExpress Port - 8081

Sample UI Request GET - localhost:8081/tableName/

Sample UI Request PUT - localhost:8081/tableName/col1=val1,col2=val2,col3=val3,col4=vl4
