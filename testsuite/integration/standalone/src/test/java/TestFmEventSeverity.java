import org.junit.*;

import com.ericsson.oss.services.fm.service.alarm.FmEventSeverity;

public class TestFmEventSeverity {

	@Test
	public void testForFmEventSeverity() {
		Assert.assertNotNull(FmEventSeverity.class);
		Assert.assertEquals("CLEARED", FmEventSeverity.CLEARED.toString());
		Assert.assertEquals("CRITICAL", FmEventSeverity.CRITICAL.toString());
		Assert.assertEquals("INDETERMINATE",
				FmEventSeverity.INDETERMINATE.toString());
		Assert.assertEquals("MAJOR", FmEventSeverity.MAJOR.toString());
		Assert.assertEquals("MINOR", FmEventSeverity.MINOR.toString());
		Assert.assertEquals("WARNING", FmEventSeverity.WARNING.toString());
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

}