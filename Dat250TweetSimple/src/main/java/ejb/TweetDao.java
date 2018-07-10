package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Tweet;


/**
 * 
 * @author Alejandro Rodriguez
 * Dat250 course
 *
 * Data Access Object connecting the Database with the business logic
 */

@Stateless
public class TweetDao {
    // Injected database connection:
	@PersistenceContext(unitName="Dat250TweetSimple")
    private EntityManager em;

    // Stores a new tweet:
    public void persist(Tweet tweet) {
        em.persist(tweet);
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