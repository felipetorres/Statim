package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Device {

	@Id
	@GeneratedValue
	private long id;
	
	private String senderHash;
	private String hash;
	
	public String getSenderHash() {
		return senderHash;
	}
	public void setSenderHash(String senderHash) {
		this.senderHash = senderHash;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
}
