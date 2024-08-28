import org.junit.*;

import com.ericsson.oss.services.fm.service.alarm.*;

public class TestAckInfo {

	AckInfo ackInfo;

	@Test
	public void testForAckInfo() {
		Assert.assertNotNull(this.ackInfo);
		Assert.assertEquals("2012-NOV-24-04-00-00", this.ackInfo.getAckTime());
		Assert.assertEquals("TCS", this.ackInfo.getOperator());
		Assert.assertEquals("ACKNOWLEDGED", this.ackInfo.getAckStatus()
				.toString());
	}

	@Before
	public void setUp() {
		this.ackInfo = new AckInfo();
		this.ackInfo.setAckStatus(FmMediationEventAckStatus.ACKNOWLEDGED);
		this.ackInfo.setAckTime("2012-NOV-24-04-00-00");
		this.ackInfo.setOperator("TCS");
	}

	@After
	public void tearDown() {
	}

}