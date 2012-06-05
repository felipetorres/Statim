package app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Device {

	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne
	private Sender sender;
	
	private String registrationId;
	
	public Device() {
		// TODO hibernate requires
	}
	
	public Device(Sender sender, String registrationId) {
		this.sender = sender;
		this.registrationId = registrationId;
	}

	public String getRegistrationId() {
		return this.registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
}
