package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Sender {

	@Id
	@GeneratedValue
	private long id;
	
	@Lob
	private String hash;
	private String email;
	
	public Object getId() {
		return this.id;
	}
	
	public Sender() {
		// TODO hibernate requires
	}
	
	public Sender(String email, String hash) {
		this.email = email;
		this.hash = hash;
	}

	public String getEmail() {
		return this.email;
	}

	public String getHash() {
		return this.hash;
	}
	
}
