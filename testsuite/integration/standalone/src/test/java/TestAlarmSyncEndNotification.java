import org.junit.*;

import com.ericsson.oss.services.fm.service.alarm.*;

public class TestAlarmSyncEndNotification {

	AlarmSyncEndNotification alarmSyncEndNotification;

	@Test
	public void testForAlarmSyncEndNotification() {
		Assert.assertNotNull(this.alarmSyncEndNotification);
	}

	@Before
	public void setUp() {
		this.alarmSyncEndNotification = new AlarmSyncEndNotification();

	}

	@After
	public void tearDown() {
	}

}