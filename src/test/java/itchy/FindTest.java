package itchy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import itchy.testsupport.FakeApp;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FindTest {
	@Before
	public void visitExamplePage() {
		browser.visit(FakeApp.EXAMPLE_URL);
	}
	
	@Test
	public void findsElementByCSS() {
		List<Element> results = browser.findByCSS("#firstForm input[type=text]");
		assertThat(results.size(), is(1));
		Element textField = results.get(0);
		assertThat(textField.name(), equalTo("firstTextField"));
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
