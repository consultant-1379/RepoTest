import org.junit.*;

import com.ericsson.oss.services.fm.service.alarm.NodeSuspendNotification;

public class TestNodeSuspendNotification {

	NodeSuspendNotification nodeSuspendNotification;

	@Test
	public void testForNodeSuspendNotification() {
		Assert.assertNotNull(this.nodeSuspendNotification);
	}

	@Before
	public void setUp() {
		nodeSuspendNotification = new NodeSuspendNotification();

	}

	@After
	public void tearDown() {
	}

}