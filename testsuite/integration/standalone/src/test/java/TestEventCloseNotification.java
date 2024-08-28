import org.junit.*;

import com.ericsson.oss.services.fm.service.alarm.*;

public class TestEventCloseNotification {

	EventCloseNotification eventCloseNotification;

	@Test
	public void testForEventCloseNotification() {
		Assert.assertNotNull(this.eventCloseNotification);
		Assert.assertEquals("TCS", this.eventCloseNotification.getOperator());
		Assert.assertEquals("ERICSSION",
				this.eventCloseNotification.getOrginatorName());
		Assert.assertEquals("E_STATE_ACTIVE_ACKNOWLEGED",
				this.eventCloseNotification.getPreviousEventState().toString());
	}

	@Before
	public void setUp() {
		this.eventCloseNotification = new EventCloseNotification();
		this.eventCloseNotification.setOperator("TCS");
		this.eventCloseNotification.setOrginatorName("ERICSSION");
		this.eventCloseNotification
				.setPreviousEventState(EventState.E_STATE_ACTIVE_ACKNOWLEGED);
	}

	@After
	public void tearDown() {
	}

}