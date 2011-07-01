package itchy;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.*;
import itchy.testsupport.FakeApp;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BrowserTest {
	
	@Before
	public void visitExamplePage() {
		browser.visit(FakeApp.EXAMPLE_URL);
	}
	
	@Test
	public void retrievesPageTitle() {
		assertThat(browser.title(), equalTo("Example Title"));
	}
	
	@Test
	public void retrievesPageHTML() {
		assertThat(browser.html(), containsString("<title>Example Title</title>"));
		assertThat(browser.html(), containsString("<h1>Example Header</h1>"));
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
 