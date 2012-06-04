package app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import app.model.Device;
import app.model.Sender;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class SenderDao {

	private final Session session;

	public SenderDao(Session session) {
		this.session = session;
	}

	public Sender findByEmail(String email) {
		List<Sender> senderList = this.session.createCriteria(Sender.class).add(Restrictions.eq("email", email)).list();
		if(!senderList.isEmpty()) {
			return senderList.get(0);
		}
		return null;
	}

	public List<Device> findDevicesOf(Sender sender) {
		return this.session.createCriteria(Device.class).add(Restrictions.eq("sender", sender)).list();
	}
}
