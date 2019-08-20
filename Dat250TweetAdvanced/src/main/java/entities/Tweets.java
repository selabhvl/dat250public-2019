package entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * @Author Alejandro Rodriguez
 * Dat250
 * 
 * The persistent class for the TWEETS extension from TWEET.
 * 
 */

@XmlRootElement
@XmlSeeAlso(Tweet.class)
public class Tweets extends ArrayList<Tweet> {

	private static final long serialVersionUID = 1L;
	
	public Tweets() {
		super();
	}

	public Tweets(Collection<? extends Tweet> c) {
		super(c);
	}

	@XmlElement(name = "tweet")
	public List<Tweet> getTweets() {
		return this;
	}

	public void setTweets(List<Tweet> tweets) {
		this.addAll(tweets);
	}
}
