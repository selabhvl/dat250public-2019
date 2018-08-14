package rest;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Tweet;
import entities.Tweets;

//To test rest operations use the url http://localhost:8080/Dat250Example0/rest/tweets

/**
 * @Author Alejandro Rodriguez
 * Dat250
 * 
 * REST operations examples
 * 
 */

@Path("/tweets")
@Stateless
public class RestService {

	@PersistenceContext(unitName = "Dat250TweetAdvanced")
	private EntityManager em;

	@GET
	@Produces(MediaType.APPLICATION_XML)

	public Response getTweets() {
		TypedQuery<Tweet> query = em.createNamedQuery(Tweet.FIND_ALL, Tweet.class);
		Tweets tweets = new Tweets(query.getResultList());
		return Response.ok(tweets).build();
	}

	@GET
	@Path("{id}")
	public Response getTweet(@PathParam("id") String id) {
		int idInt = Integer.parseInt(id);
		Tweet tweet = em.find(Tweet.class, idInt);
		if (tweet == null)
			throw new NotFoundException();
		return Response.ok(tweet).build();
	}
}
