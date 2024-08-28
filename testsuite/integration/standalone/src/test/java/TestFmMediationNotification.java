import org.junit.*;

import com.ericsson.oss.services.fm.service.alarm.*;

public class TestFmMediationNotification {

	FmMediationNotification fmMediationNotification;

	@Test
	public void testForFmMediationNotification() {
		Assert.assertNotNull(this.fmMediationNotification);
		Assert.assertEquals("probableCause",
				this.fmMediationNotification.getProbableCause());
		Assert.assertEquals("specificProblem",
				this.fmMediationNotification.getSpecificProblem());
		Assert.assertEquals("TestType", this.fmMediationNotification.getEventType());
	}

	@Before
	public void setUp() {
		this.fmMediationNotification = new FmMediationNotification();
		this.fmMediationNotification.setEventType("TestType");
		this.fmMediationNotification.setProbableCause("probableCause");
		this.fmMediationNotification.setSpecificProblem("specificProblem");
	}

	@After
	public void tearDown() {
	}

}