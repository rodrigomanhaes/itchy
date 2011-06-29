package itchy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import itchy.testsupport.FakeApp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BaseSpec {
	
	private static FakeApp app;
	
	@BeforeClass
	public static void serverUp() {
		app = new FakeApp();
		app.up();
	}
	
	@AfterClass
	public static void serverDown() {
		app.down();
	}
	
	@Test
	public void itSums() {
		Itchy hi = new Itchy();
		assertThat(hi, is(notNullValue()));
	}
}
 