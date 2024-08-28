import java.util.HashMap;

import org.junit.*;

import com.ericsson.oss.services.fm.service.alarm.*;

public class TestAlarmNotification {

	AlarmNotification alarmNotification;

	@Test
	public void testForAlarmNotification() {
		Assert.assertNotNull(this.alarmNotification);
		Assert.assertEquals("CRITICAL", this.alarmNotification
				.getPerceivedSeverity().toString());
		Assert.assertEquals("sourceType",
				this.alarmNotification.getSourceType());
		Assert.assertEquals("eventAgentId",
				this.alarmNotification.getEventAgentId());
		Assert.assertEquals(1000, this.alarmNotification
				.getFmMediationEventId().getNumId());

		Assert.assertEquals("Test", this.alarmNotification
				.getFmMediationEventId().getStringId());

	}

	@Before
	public void setUp() {
		this.alarmNotification = new AlarmNotification();
		this.alarmNotification.setPerceivedSeverity(FmEventSeverity.CRITICAL);
		this.alarmNotification.setSourceType("sourceType");
		this.alarmNotification.setEventAgentId("eventAgentId");
		this.alarmNotification.setEventType("eventType");
		final FmMediationEventId fmMediationEventId = new FmMediationEventId();
		fmMediationEventId.setNumId(1000);
		fmMediationEventId.setStringId("Test");
		this.alarmNotification.setFmMediationEventId(fmMediationEventId);
	}

	@After
	public void tearDown() {
	}

}