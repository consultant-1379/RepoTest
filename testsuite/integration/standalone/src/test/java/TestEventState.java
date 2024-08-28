import org.junit.*;

import com.ericsson.oss.services.fm.service.alarm.EventState;

public class TestEventState {

	@Test
	public void testForEventState() {
		Assert.assertNotNull(EventState.class);
		Assert.assertEquals("E_STATE_ACTIVE_ACKNOWLEGED",
				EventState.E_STATE_ACTIVE_ACKNOWLEGED.toString());
		Assert.assertEquals("E_STATE_ACTIVE_UNACKNOWLEGED",
				EventState.E_STATE_ACTIVE_UNACKNOWLEGED.toString());
		Assert.assertEquals("E_STATE_CLEARED_ACKNOWLEGED",
				EventState.E_STATE_CLEARED_ACKNOWLEGED.toString());
		Assert.assertEquals("E_STATE_CLEARED_UNACKNOWLEGED",
				EventState.E_STATE_CLEARED_UNACKNOWLEGED.toString());
		Assert.assertEquals("E_STATE_CLOSED",
				EventState.E_STATE_CLOSED.toString());
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

}