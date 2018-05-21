#  Spring security oauth2 example

## Prerequisites:
* MySQL 5.7
* JDK 1.8 
* Maven 3.*

## Install and run the project 
1. download/clone the project 
2. prepare the database
  * import in MySQL the self-contained file that comes with the project -  [th_auth.sql]  ( https://github.com/mukhtiarahmed/auth-service/blob/master/db_script/th_auth.sql )
  * username/password - `auth_app`/`auth_app`
  
3. change to the root folder of the project and excute the following maven command 
  * `mvn spring-boot:run`
  * now the REST api is up and running with tomcat 8 on `localhost:8080`
     
     
4. Let's check if our authentication endpoint is working
   * `curl -X POST   http://localhost:8080/oauth/token   -H 'authorization: Basic YnJvd3NlcjpzZWNyZXQ=' -F grant_type=password   -F username=ahmed   -F password=ahmed   -F scope=trust`
  