import org.junit.*;

import com.ericsson.oss.services.fm.service.alarm.FmMediationEventId;

public class TestFmMediationEventId {


	FmMediationEventId fmMediationEventId;

	@Test
	public void testForFmMediationEventId() {
		Assert.assertNotNull(this.fmMediationEventId);
		Assert.assertEquals(1000000L, this.fmMediationEventId.getNumId());
		Assert.assertEquals("StringID", this.fmMediationEventId.getStringId());
	}

	@Before
	public void setUp() {
		this.fmMediationEventId = new FmMediationEventId();
		this.fmMediationEventId.setNumId(1000000L);
		this.fmMediationEventId.setStringId("StringID");
	}

	@After
	public void tearDown() {
	}

}