import org.junit.*;

import com.ericsson.oss.services.fm.service.alarm.AlarmSyncAbortNotification;

public class TestAlarmSyncAbortNotification {

	AlarmSyncAbortNotification alarmSyncAbortNotification;

	@Test
	public void testForFAlarmSyncAbortNotification() {
		Assert.assertNotNull(this.alarmSyncAbortNotification);
	}

	@Before
	public void setUp() {
		this.alarmSyncAbortNotification = new AlarmSyncAbortNotification();

	}

	@After
	public void tearDown() {
	}

}