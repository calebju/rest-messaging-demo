$ ./mvnw spring-boot:run
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building rest-messaging-demo 0.1.0
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] >>> spring-boot-maven-plugin:1.5.3.RELEASE:run (default-cli) > test-compile @ rest-messaging-demo >>>
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ rest-messaging-demo ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/cju/Development/rest-messaging-demo/src/main/resources
[INFO] skip non existing resourceDirectory /Users/cju/Development/rest-messaging-demo/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ rest-messaging-demo ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 5 source files to /Users/cju/Development/rest-messaging-demo/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ rest-messaging-demo ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/cju/Development/rest-messaging-demo/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ rest-messaging-demo ---
[INFO] No sources to compile
[INFO] 
[INFO] <<< spring-boot-maven-plugin:1.5.3.RELEASE:run (default-cli) < test-compile @ rest-messaging-demo <<<
[INFO] 
[INFO] --- spring-boot-maven-plugin:1.5.3.RELEASE:run (default-cli) @ rest-messaging-demo ---

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.5.3.RELEASE)

2017-07-01 02:43:22.357  INFO 5669 --- [           main] demo.Application                         : Starting Application on Calebs-MacBook-Air.local with PID 5669 (/Users/cju/Development/rest-messaging-demo/target/classes started by cju in /Users/cju/Development/rest-messaging-demo)
2017-07-01 02:43:22.360  INFO 5669 --- [           main] demo.Application                         : No active profile set, falling back to default profiles: default
2017-07-01 02:43:22.429  INFO 5669 --- [           main] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@30d3986a: startup date [Sat Jul 01 02:43:22 CST 2017]; root of context hierarchy
2017-07-01 02:43:24.255  INFO 5669 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8080 (http)
2017-07-01 02:43:24.279  INFO 5669 --- [           main] o.apache.catalina.core.StandardService   : Starting service Tomcat
2017-07-01 02:43:24.281  INFO 5669 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.14
2017-07-01 02:43:24.442  INFO 5669 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2017-07-01 02:43:24.444  INFO 5669 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 2020 ms
2017-07-01 02:43:24.687  INFO 5669 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'dispatcherServlet' to [/]
2017-07-01 02:43:24.695  INFO 5669 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
2017-07-01 02:43:24.696  INFO 5669 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
2017-07-01 02:43:24.697  INFO 5669 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
2017-07-01 02:43:24.698  INFO 5669 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
2017-07-01 02:43:25.352  INFO 5669 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@30d3986a: startup date [Sat Jul 01 02:43:22 CST 2017]; root of context hierarchy
2017-07-01 02:43:25.495  INFO 5669 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/postmsg]}" onto public java.util.List<java.lang.String> demo.SubscriptionController.postMsg(java.lang.String,java.lang.String)
2017-07-01 02:43:25.497  INFO 5669 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/createSub]}" onto public java.util.List<java.lang.String> demo.SubscriptionController.createSubscription(java.lang.String)
2017-07-01 02:43:25.498  INFO 5669 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/updateSub]}" onto public java.util.List<java.lang.String> demo.SubscriptionController.updateSubscription(java.lang.String,long)
2017-07-01 02:43:25.498  INFO 5669 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/readSub]}" onto public java.util.List<java.lang.String> demo.SubscriptionController.readSubscription(long)
2017-07-01 02:43:25.502  INFO 5669 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
2017-07-01 02:43:25.503  INFO 5669 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
2017-07-01 02:43:25.568  INFO 5669 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2017-07-01 02:43:25.568  INFO 5669 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2017-07-01 02:43:25.651  INFO 5669 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2017-07-01 02:43:26.090  INFO 5669 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2017-07-01 02:43:26.101  INFO 5669 --- [           main] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 2147483647
2017-07-01 02:43:31.181  WARN 5669 --- [           main] o.apache.activemq.broker.BrokerService   : Memory Usage for the Broker (1024mb) is more than the maximum available for the JVM: 910 mb - resetting to 70% of maximum available: 637 mb
2017-07-01 02:43:36.232  INFO 5669 --- [           main] o.apache.activemq.broker.BrokerService   : Using Persistence Adapter: MemoryPersistenceAdapter
2017-07-01 02:43:36.273  INFO 5669 --- [  JMX connector] o.a.a.broker.jmx.ManagementContext       : JMX consoles can connect to service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi
2017-07-01 02:43:41.406  INFO 5669 --- [           main] o.apache.activemq.broker.BrokerService   : Apache ActiveMQ 5.14.5 (localhost, ID:Calebs-MacBook-Air.local-55388-1498848221262-0:1) is starting
2017-07-01 02:43:41.415  INFO 5669 --- [           main] o.apache.activemq.broker.BrokerService   : Apache ActiveMQ 5.14.5 (localhost, ID:Calebs-MacBook-Air.local-55388-1498848221262-0:1) started
2017-07-01 02:43:41.415  INFO 5669 --- [           main] o.apache.activemq.broker.BrokerService   : For help or more information please see: http://activemq.apache.org
2017-07-01 02:43:41.418  WARN 5669 --- [           main] o.apache.activemq.broker.BrokerService   : Temporary Store limit is 51200 mb (current store usage is 0 mb). The data directory: /Users/cju/Development/rest-messaging-demo only has 51010 mb of usable space. - resetting to maximum available disk space: 51010 mb
2017-07-01 02:43:41.468  INFO 5669 --- [           main] o.a.activemq.broker.TransportConnector   : Connector vm://localhost started
2017-07-01 02:43:41.633  INFO 5669 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2017-07-01 02:43:41.640  INFO 5669 --- [           main] demo.Application                         : Started Application in 29.772 seconds (JVM running for 35.691)
Sending a test news message
Sending a test alert message
Sending a test todo message
Received <Message{type=news, createTime=2017-07-01T02:43:41.652, body=This is a test news message.}>
Received <Message{type=alert, createTime=2017-07-01T02:43:41.780, body=This is a test alert message.}>
Received <Message{type=todo, createTime=2017-07-01T02:43:41.800, body=This is a test todo message.}>
2017-07-01 02:49:21.637  INFO 5669 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring FrameworkServlet 'dispatcherServlet'
2017-07-01 02:49:21.637  INFO 5669 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization started
2017-07-01 02:49:21.670  INFO 5669 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 33 ms
