package itchy;

import static itchy.ItchySuite.browser;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import itchy.testsupport.FakeApp;

import org.junit.Before;
import org.junit.Test;

public class ElementTest {
	@Before
	public void visitExamplePage() {
		browser.visit(FakeApp.EXAMPLE_URL);
	}

	@Test
	public void retrievesItsName() {
		Element element = browser.findByName("first").get(0);
		assertThat(element.name(), equalTo("first"));
	}
	
	@Test
	public void retrievesItsId() {
		assertThat(browser.findById("firstForm").id(), equalTo("firstForm"));
	}
	
	@Test
	public void getAtributesByName() {
		Element link = browser.findById("home");
		assertThat(link.attr("href"), equalTo("https://github.com/rodrigomanhaes/itchy"));
		assertThat(link.attr("rel"), equalTo("our-site"));
		assertThat(link.attr("tabindex"), equalTo("3"));
	}
}
