1. This project demos the basic java messaging services. In the Application class, there is a fix-sized queue to cache received messages locally for REST API clients. Subscribers can conveniently use HTTP requests to post messages and create/read/update/remove their subscriptions. There is no need to use JMX connections for each subscriber in order to boost performance. Technologies used in this project include the following:

JDK 1.8
Spring Boot Framework 1.5.3
Embedded Apache ActiveMQ 5.14.5
Embedded Tomcat Servlet Container
REST API
JMX API
JSON
Maven

2. By default, Spring Boot creates JmsTemplate and JmsMessageListenerContainer by having pubSubDomain set to false, for Queue type of messages. To override, set the following:

// Setup JmsTemplate to produce Topic type of messages
// Setup JmsListener to consume Topic type of messages
factory.setPubSubDomain(true);
jmsTemplate.setPubSubDomain(true);

3. With Maven, you can run the application using ./mvnw spring-boot:run
Or you can build the JAR file with ./mvnw clean package

4. This code uses Spring’s @RestController annotation, which marks the class as a controller and uses the Jackson JSON library to automatically marshal instances of type List into JSON.

5. Spring Boot automatically flags this application as a web application and initializes a DispatcherServlet when the first http request arrives.

6. All REST APIs accept HTTP GET requests for easy testing (@RequestMapping maps all HTTP operations by default) and respond with a JSON representation of a List object.

7. To post a message with one of the three predefined types - "news, alert, todo"

HTTP Request: http://localhost:8080/postmsg?msg=test%20more&type=alert

HTTP Response: ["Message has been posted with type: alert body: test more"]

8. To create a subscription with any of the three predefined types - "news, alert, todo"

HTTP Request: http://localhost:8080/createSub?types=alert%20news%20todo

HTTP Response: ["A new subscription has been created with id: 2 types: alert news todo"]

9. To update a subscription with any of the three predefined types - "news, alert, todo" and its subscription id

HTTP Request: http://localhost:8080/updateSub?types=alert%20news&subid=1

HTTP Response: ["Subscription has been updated with id: 1 types: alert news"]

10. To remove a subscription with only its subscription id

HTTP Request: http://localhost:8080/updateSub?subid=1

HTTP Response: ["Subscription has been removed with id: 1"]

11. To read a subscription with its subscription id

HTTP Request: http://localhost:8080/readSub?subid=2

HTTP Response: ["Message{type=todo, createTime=2017-07-01T01:56:50.891, body=This is a test todo message.}","Message{type=alert, createTime=2017-07-01T01:56:50.868, body=This is a test alert message.}","Message{type=news, createTime=2017-07-01T01:56:50.745, body=This is a test news message.}"]
