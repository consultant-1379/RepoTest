import org.junit.*;

import com.ericsson.oss.services.fm.service.alarm.AlarmSyncStartNotification;

public class TestAlarmSyncStartNotification {

	AlarmSyncStartNotification alarmSyncStartNotification;

	@Test
	public void testForAlarmSyncStartNotification() {
		Assert.assertNotNull(this.alarmSyncStartNotification);
	}

	@Before
	public void setUp() {
		this.alarmSyncStartNotification = new AlarmSyncStartNotification();

	}

	@After
	public void tearDown() {
	}

}