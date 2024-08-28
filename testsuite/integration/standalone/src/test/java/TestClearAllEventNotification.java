import org.junit.*;

import com.ericsson.oss.services.fm.service.alarm.ClearAllEventNotification;

public class TestClearAllEventNotification {

	ClearAllEventNotification clearAllEventNotification;

	@Test
	public void testForClearAllEventNotification() {
		Assert.assertNotNull(this.clearAllEventNotification);
		Assert.assertEquals("topObjectName",
				this.clearAllEventNotification.getTopObjectName());
	}

	@Before
	public void setUp() {
		this.clearAllEventNotification = new ClearAllEventNotification();
		this.clearAllEventNotification.setTopObjectName("topObjectName");

	}

	@After
	public void tearDown() {
	}

}