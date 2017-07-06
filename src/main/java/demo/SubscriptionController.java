package demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

@RestController
public class SubscriptionController {

    // Generate subscription id through a counter for all REST API clients
    private static final AtomicLong subidCounter = new AtomicLong();

    @Autowired // Set up boot's ApplicationContext to get jmsTemplate bean
    private ConfigurableApplicationContext context;

    // Post a message through http request - http://localhost:8080/postmsg?msg=test%20again&type=alert
    // Respond with a JSON representation of List object
    @RequestMapping("/postmsg")
    public List<String> postMsg(@RequestParam(value="msg", defaultValue="test message") String msg, @RequestParam(value="type", defaultValue="news") String type) {
        List<String> result = new ArrayList<String>();

        // JmsTemplate has been setup to produce Topic type of messages
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        // Setup JmsTemplate to produce Topic type of messages
        jmsTemplate.setPubSubDomain(true);

        // Send message with a POJO through jackson message converter
        System.out.println("Sending a message with type " + type);
        jmsTemplate.convertAndSend(Application.msgQueueName, new Message(type, msg));

        result.add("Message has been posted with type: " + type + " body: " + msg);
        
        return result;
    }

    // Create a subscription through http request - http://localhost:8080/createSub?types=alert%20news%20todo
    // Respond with a JSON representation of List object
    @RequestMapping("/createSub")
    public List<String> createSubscription(@RequestParam(value="types", defaultValue="") String types) {        
        List<String> result = new ArrayList<String>();
        String str = "There is no types found in request";

        // Check and add a new subscription to msgSubscription HashMap
        // types can be like "alert news todo"
        if (!types.isEmpty()) {
        	
            // Generate subscription id
            long subid = subidCounter.incrementAndGet();
            
            Application.msgSubscription.put(subid, types);

            str = "A new subscription has been created with id: " + subid + " types: " + types;
        }

        result.add(str);
        
        return result;
    }
    
    // Update a subscription through http request - http://localhost:8080/updateSub?types=alert%20news&subid=1
    // Remove a subscription through http request - http://localhost:8080/updateSub?subid=1
    // Respond with a JSON representation of List object
    @RequestMapping("/updateSub")
    public List<String> updateSubscription(@RequestParam(value="types", defaultValue="") String types, @RequestParam(value="subid", defaultValue="0") long subid) {
        List<String> result = new ArrayList<String>();
        String str = "";

        // Check and update/remove a subscription from msgSubscription HashMap
        if (Application.msgSubscription.containsKey(subid)) {
        	
            // Based on types, to figure out either update or remove a subscription
            if (!types.isEmpty()) {
                // Update subscription
                Application.msgSubscription.replace(subid, types);

                str = "Subscription has been updated with id: " + subid + " types: " + types;
            }
            else {
                // Remove subscription
                Application.msgSubscription.remove(subid);

                str = "Subscription has been removed with id: " + subid;
            }
        }
        else {
            // No subscription found with this id
            str = "Cannot find the subscription with id: " + subid;
        }

        result.add(str);
        
        return result;
    }


    // Read all subscribed messages through http request - http://localhost:8080/readSub?subid=1
    // Respond with a JSON representation of List object
    @RequestMapping("/readSub")
    public List<String> readSubscription(@RequestParam(value="subid", defaultValue="0") long subid) {
        List<String> result = new ArrayList<String>();
        String str = "";

        // Check and get subscription types from msgSubscription HashMap
        if (Application.msgSubscription.containsKey(subid)) {
            
            String types = Application.msgSubscription.get(subid);
            
            // Filter all previously received messages through the subscription types
            Application.msgQueue.stream()                          // convert msgQueue to stream
                .filter(x -> types.contains(x.getType()))          // filter by subscription types
                .map(Object::toString)                             // convert message object to string
                .collect(Collectors.toCollection(LinkedList::new)) // collect and convert output
                .descendingIterator()                              // display the latest message first
                .forEachRemaining(result::add);                    // add message to result
                        
        }
        else {
            str = "Cannot find the subscription with id: " + subid;
            result.add(str);
        }

        return result;
    }
}