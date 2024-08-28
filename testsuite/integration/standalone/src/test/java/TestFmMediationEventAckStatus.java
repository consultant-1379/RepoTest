
import org.junit.*;

import com.ericsson.oss.services.fm.service.alarm.FmMediationEventAckStatus;

public class TestFmMediationEventAckStatus {
	
//	@Inject
//	private Logger logger;
	
	
	@Test
	public void testForFmMediationEventAckStatus() { 
	   Assert.assertNotNull(FmMediationEventAckStatus.class);	
	   Assert.assertEquals("ACKNOWLEDGED",  FmMediationEventAckStatus.ACKNOWLEDGED.toString());
	   Assert.assertEquals("NOT_ACKNOWLEDGED",  FmMediationEventAckStatus .NOT_ACKNOWLEDGED.toString());
	} 

	
	@Before
	public void setUp() { 
	} 
	
	
	@After
	public void tearDown() { 
	} 

}