package app.controller;

import app.dao.SenderDao;
import app.model.Sender;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class SenderController {
	
	private final SenderDao senders;

	public SenderController(SenderDao senders) {
		this.senders = senders;
	}

	@Path("/sender/{email}/{hash}")
	public void save(String email, String hash) {
		Sender sender = new Sender(email, hash);
		senders.save(sender);
	}
	
	@Path("/sender/update/{email}/{hash}")
	public void update(String email, String hash) {
		senders.update(email, hash);
	}
}
