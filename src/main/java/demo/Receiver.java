package demo;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    // myFactory has setPubSubDomain to true for Topic type of messages
    @JmsListener(destination = Application.msgQueueName, containerFactory = "myFactory")
    public void receiveMessage(Message message) {
    	
        System.out.println("Received <" + message + ">");

        // Store received messages locally for REST API clients
        Application.msgQueue.add(message);
    }

}
