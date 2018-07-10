package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * @Author Alejandro Rodriguez
 * Dat250
 * 
 * The persistent class for the TWEET database table.
 * 
 */

@Entity
@Table(name="tweet")
@NamedQuery(name="Tweet.findAll", query="SELECT t FROM Tweet t")
public class Tweet implements Serializable {
	private static final long serialVersionUID = 1L;

	//Create elements ids automatically, incremented 1 by 1
	@TableGenerator(
			  name = "yourTableGenerator",
			  allocationSize = 1,
			  initialValue = 1)
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="yourTableGenerator")
	private int id;

	private String message;

	private String author;

	public Tweet() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	

}