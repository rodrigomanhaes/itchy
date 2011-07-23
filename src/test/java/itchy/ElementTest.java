package itchy;

import static itchy.ItchySuite.browser;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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
	public void retrievesItsValue() {
		assertThat(browser.findById("preValued").value(), equalTo("Type something here"));
	}
	
	@Test
	public void getAtributesByName() {
		Element link = browser.findById("home");
		assertThat(link.attr("href"), equalTo("https://github.com/rodrigomanhaes/itchy"));
		assertThat(link.attr("rel"), equalTo("our-site"));
		assertThat(link.attr("tabindex"), equalTo("3"));
	}
	
	@Test
	public void retrievesItsContent() {
		Element link = browser.findById("home");
		assertThat(link.content(), equalTo("Itchy Home"));
	}
	
	@Test
	public void choosesRadioButton() {
		assertThat(browser.findById("fb").isChosen(), is(false));
		browser.findById("fb").choose();
		assertThat(browser.findById("fb").isChosen(), is(true));
	}
}
