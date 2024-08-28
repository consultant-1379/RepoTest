import org.junit.*;

import com.ericsson.oss.services.fm.service.alarm.AckNotification;

public class TestAckcNotification {

	AckNotification ackNotification;

	@Test
	public void testForFmEventTime() {
		Assert.assertNotNull(this.ackNotification);
	}

	@Before
	public void setUp() {
		this.ackNotification = new AckNotification();

	}

	@After
	public void tearDown() {
	}

}