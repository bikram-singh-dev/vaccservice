# vaccservice

Pre Requisites:

1.Java 11

2.STS 4 or similar IDE



# Steps to run:
1.Run VaccserviceApplication.class as a spring boot app.

2.To access DB:

   a).Go to browser and paste "http://localhost:8321/h2-console"
   
   b).Make user the "JDBC URL" is "jdbc:h2:mem:vaccnowDB"
   
   c).User name: sa
   
   d).Password: (blank) and click "connect"
   
3.To check API endpoints go to browser and paste "http://localhost:8321/swagger-ui.html"

Note: Not using any mail server and just firing a new thread to log the email message and subject along with recepient email address on the console.

Date format to be used: **YYYY-mm-dd**

Datetime format to be used: **YYYY-mm-ddTHH:mm:ss**
