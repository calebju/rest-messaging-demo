package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import javax.jms.ConnectionFactory;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@EnableJms
public class Application {

    // Define a generic message queue name for message broker
    static final String msgQueueName = "msg-queue";

    // Define different types of messages
    static final String newsType = "news";
    static final String alertType = "alert";
    static final String todoType = "todo";

    // Define counters for different types of messages read by all REST API clients
    static final AtomicLong newsTypeCounter = new AtomicLong();
    static final AtomicLong alertTypeCounter = new AtomicLong();
    static final AtomicLong todoTypeCounter = new AtomicLong();

    // Store received messages locally for REST API clients in a FixedSizeQueue with total 100 messages
    static final FixedSizeQueue<Message> msgQueue = new FixedSizeQueue<Message>(100);

    // Store subscriptions locally for REST API clients in a HashMap -
    // with subscription id as the key
    // with message types as the value
    static final ConcurrentHashMap<Long, String> msgSubscription = new ConcurrentHashMap<Long, String>();

    @Bean
    public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
        
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        
        // This provides all boot's default to this factory, including the message converter
        configurer.configure(factory, connectionFactory);
        
        // Override Boot's default here
        // Setup JmsTemplate to produce Topic type of messages
        // Setup JmsListener to consume Topic type of messages
        factory.setPubSubDomain(true);
        
        return factory;
    }

    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {
        
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        
        return converter;
    }

    public static void main(String[] args) {
        // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        // Setup JmsTemplate to produce Topic type of messages
        jmsTemplate.setPubSubDomain(true);
        
        // Send message with a POJO through jackson message converter
        System.out.println("Sending a test news message");
        jmsTemplate.convertAndSend(Application.msgQueueName, new Message(newsType, "This is a test news message."));

        // Send message with a POJO through jackson message converter
        System.out.println("Sending a test alert message");
        jmsTemplate.convertAndSend(Application.msgQueueName, new Message(alertType, "This is a test alert message."));

        // Send message with a POJO through jackson message converter
        System.out.println("Sending a test todo message");
        jmsTemplate.convertAndSend(Application.msgQueueName, new Message(todoType, "This is a test todo message."));
        
        // Spring Boot automatically flags the application as a web application
        // It will set up a DispatcherServlet when the first http request arrives
    }
}
