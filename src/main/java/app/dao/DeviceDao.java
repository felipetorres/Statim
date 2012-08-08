package app.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import app.model.Device;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class DeviceDao {

	private final Session session;

	public DeviceDao(Session session) {
		this.session = session;
	}

	public void save(Device device) {
		session.save(device);
	}
	
	public boolean contains(String hash) {
		return find(hash) != null;
	}

	public Device find(String hash) {
		return (Device) this.session.createCriteria(Device.class).add(Restrictions.eq("registrationId", hash)).uniqueResult();
	}
	
	public Device findById(long id) {
		return (Device) this.session.createCriteria(Device.class).add(Restrictions.eq("id", id)).uniqueResult();
	}
	
	public void update(String oldHash, String newHash) {
		Device found = find(oldHash);
		found.setRegistrationId(newHash);
		session.update(found);
	}

	public void delete(Device device) {
		Device found = find(device.getRegistrationId());
		if(found != null) {
			session.delete(found);
		}
	}
}
