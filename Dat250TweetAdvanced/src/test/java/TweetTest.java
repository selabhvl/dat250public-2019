

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Tweet;


/**
 * @Author Alejandro Rodriguez
 * Dat250
 * 
 * Test class for displaying the tweets in the database
 * 
 */

public class TweetTest {

    private static final String PERSISTENCE_UNIT_NAME = "Dat250TweetAdvanced";
    private static EntityManagerFactory factory;
	
	public static void main(String[] args) {
		 factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	        EntityManager em = factory.createEntityManager();
	        // read the existing entries and write to console
	        Query q = em.createQuery("select s from Tweet s");
	        @SuppressWarnings("unchecked")
			List<Tweet> tweets = q.getResultList();
	        for (Tweet s : tweets) {
	            System.out.println(s);
	        }
	}

}
