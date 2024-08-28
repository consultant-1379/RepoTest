import org.junit.*;

import com.ericsson.oss.services.fm.service.alarm.*;

public class TestMediationNotification {

	MediationNotification mediationNotification;

	@Test
	public void testForFmMediationNotification() {
		Assert.assertNotNull(this.mediationNotification);
		Assert.assertEquals("JobID", this.mediationNotification.getJobID());
		Assert.assertEquals("NodeAddress",
				this.mediationNotification.getNodeAddress());
	}

	@Before
	public void setUp() {
		this.mediationNotification = new MediationNotification();
		this.mediationNotification.setJobID("JobID");
		this.mediationNotification.setNodeAddress("NodeAddress");
	}

	@After
	public void tearDown() {
	}

}