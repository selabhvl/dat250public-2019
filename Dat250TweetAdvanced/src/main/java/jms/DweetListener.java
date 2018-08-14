package jms;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import com.google.gson.JsonObject;

import entities.Tweet;

/**
 * @Author Alejandro Rodriguez Dat250
 * 
 * Listener triggered when a tweet is sent to the Topic JMS. It filters
 * the topic for "dweet"
 * 
 */

@MessageDriven(mappedName = "jms/dat250/Topic", activationConfig = {
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
		@ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "topicUser = 'dweet'") })
public class DweetListener implements MessageListener {

	@Override
	public void onMessage(Message message) {

		try {
			Tweet tweet = message.getBody(Tweet.class);
			JsonObject json = new JsonObject();
			json.addProperty("User", tweet.getAuthor());
			json.addProperty("Message", tweet.getMessage());
			
			Logger logger = Logger.getLogger(getClass().getName());
			logger.info("DTWEET User: " + tweet.getAuthor()); 
			logger.info("DTWEET Message: " + tweet.getMessage());
			logger.info("DTWEET: Sending tweet to dweet...");
			logger.info("DTWEET JSON: " + json);
			try {
				DweetConnection dc = new DweetConnection();
				dc.publish(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}