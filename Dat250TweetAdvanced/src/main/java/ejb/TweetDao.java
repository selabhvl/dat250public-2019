package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSSessionMode;
import javax.jms.Topic;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Tweet;

/**
 * 
 * @author Alejandro Rodriguez
 * Dat250 course
 *
 *Data Access Object connecting the Database with the business logic
 */

@Stateless
public class TweetDao {
	
    // Injected database connection:
	@PersistenceContext(unitName="Dat250TweetAdvanced")
    private EntityManager em;
	
	
	@Inject
	@JMSConnectionFactory("jms/dat250/ConnectionFactory")
	@JMSSessionMode(JMSContext.AUTO_ACKNOWLEDGE)
	private JMSContext context;
	
	@Resource(lookup = "jms/dat250/Topic")
	private Topic topic;
	
    // Stores a new tweet:
    public void persist(Tweet tweet) throws NamingException, JMSException {
        em.persist(tweet);
        //Send the topic to the JMS Topic
		context.createProducer().setProperty("topicUser", tweet.getTopic()).send(topic, tweet);

    }

    // Retrieves all the tweets:
	@SuppressWarnings("unchecked")
	public List<Tweet> getAllTweets() {
        Query query = em.createQuery("SELECT t FROM Tweet t");
        List<Tweet> tweets = new ArrayList<Tweet>();
        tweets = query.getResultList();
        return tweets;
    }
}