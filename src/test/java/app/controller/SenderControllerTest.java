package app.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import app.dao.SenderDao;
import app.model.Sender;

public class SenderControllerTest {

	private @Mock SenderDao senders;
	private SenderController controller;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		controller = new SenderController(senders);
	}
	
	@Test
	public void shouldSaveSender() throws Exception {
		controller.save("sender@email.com", "aSenderHash");
		verify(senders).save(any(Sender.class));
	}
	
	@Test
	public void shouldUpdateSender() throws Exception {
		String senderEmail = "sender@email.com";

		controller.update(senderEmail, "aNewHash");
		
		verify(senders).update(senderEmail, "aNewHash");
	}
}
