import org.junit.*;

import com.ericsson.oss.services.fm.service.alarm.*;

public class TestSyncNotification {

	SyncNotification syncNotification;

	@Test
	public void testForSyncNotification() {
		Assert.assertNotNull(this.syncNotification);
	}

	@Before
	public void setUp() {
		this.syncNotification = new SyncNotification();

	}

	@After
	public void tearDown() {
	}

}