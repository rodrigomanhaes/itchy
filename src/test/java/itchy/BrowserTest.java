package itchy;

import static itchy.ItchySuite.browser;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import itchy.testsupport.FakeApp;

import org.junit.Before;
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
}
 