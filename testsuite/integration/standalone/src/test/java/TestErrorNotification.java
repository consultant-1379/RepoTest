import org.junit.*;

import com.ericsson.oss.services.fm.service.alarm.*;

public class TestErrorNotification {

	ErrorNotification errorNotification;

	@Test
	public void testForErrorNotification() {
		Assert.assertNotNull(this.errorNotification);
	}

	@Before
	public void setUp() {
		this.errorNotification = new ErrorNotification();

	}

	@After
	public void tearDown() {
	}

}