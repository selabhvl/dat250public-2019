package ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.resource.spi.SecurityException;

import entities.Tweet;

/**
 * 
 * @author Alejandro Rodriguez
 * Dat250 course
 *
 *   Tweet Controller class for the management of tweets
 */

@Named(value = "tweetController")
@RequestScoped
public class TweetController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Injected DAO EJB:
	@EJB
	private TweetDao tweetDao;

	private Tweet tweet;

	public List<Tweet> getTweets() {
		List<Tweet> reverseTweetList = new ArrayList<Tweet>();
		reverseTweetList.addAll(this.tweetDao.getAllTweets());
		Collections.reverse(reverseTweetList);
		return reverseTweetList;

	}

	public String saveTweet() throws NamingException, JMSException {
		SessionUtils.getUserName();
		this.tweet.setAuthor(SessionUtils.getUserName());
		this.tweetDao.persist(this.tweet);
		return Constants.INDEX;
	}

	public Tweet getTweet() {
		if (this.tweet == null) {
			tweet = new Tweet();
		}
		return tweet;

	}

}
