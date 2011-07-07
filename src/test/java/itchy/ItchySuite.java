package itchy;

import itchy.testsupport.FakeApp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	BrowserTest.class,
	FindTest.class
})
public class ItchySuite {
	private static FakeApp app;
	public static Browser browser;
	
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
