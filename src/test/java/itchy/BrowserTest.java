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
		browser.visit(FakeApp.EXAMPLE_URL);
		assertThat(browser.title(), equalTo("Example Title"));
	}
	
	private static FakeApp app;
	private static Browser browser;
	
	@BeforeClass
	public static void serverUp() {
		app = new FakeApp();
		app.up();
		browser = new Browser();		
	}
	
	@AfterClass
	public static void serverDown() {
		browser.quit();
		app.down();
	}
}
 