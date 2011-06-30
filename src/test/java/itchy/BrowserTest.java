package itchy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import itchy.testsupport.FakeApp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BrowserTest {
	
	@Test
	public void visitsAnUrl() {
		Browser browser = new Browser();
		browser.visit(FakeApp.EXAMPLE_URL);
		assertThat(browser.title(), equalTo("Example Title"));
	}
	
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
}
 