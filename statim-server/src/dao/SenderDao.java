package dao;

import java.util.List;

import model.Device;
import model.Sender;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
