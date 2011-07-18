package itchy;

import static itchy.ItchySuite.browser;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import itchy.testsupport.FakeApp;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsNull;
import org.junit.Before;
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
	
	@Test
	public void findsElementByXPath() {
		List<Element> results = browser.findByXPath("//form[@id='firstForm']/input[@type='text']");
		assertThat(results.size(), is(1));
		Element textField = results.get(0);
		assertThat(textField.name(), equalTo("firstTextField"));
	}
	
	@Test
	public void findsElementsByTag() {
		List<Element> forms = browser.findByTag("form");
		assertThat(forms.get(0).id(), equalTo("firstForm"));
		assertThat(forms.get(1).id(), equalTo("secondForm"));
	}
	
	@Test
	public void findElementById() {
		Element element = browser.findById("secondForm");
		assertThat(element.id(), equalTo("secondForm"));
		assertThat(element.name(), equalTo("second"));
		
		assertThat(browser.findById("doesn't exist"), is(nullValue()));
	}
	
	@Test
	public void findElementsByName() {
		List<Element> elements = browser.findByName("sport");
		assertThat(elements.size(), equalTo(4));
		List<String> ids = new ArrayList<String>();
		for (Element element: elements)
			ids.add(element.id());
		assertThat(ids, hasItem("fb"));
		assertThat(ids, hasItem("hb"));
		assertThat(ids, hasItem("bb"));
		assertThat(ids, hasItem("vb"));
	}
	
	@Test
	public void findLinksByText() {
		List<Element> elements = browser.findLinksByText("Itchy Home");
		assertThat(elements.size(), equalTo(1));
		assertThat(elements.get(0).attr("href"), equalTo("https://github.com/rodrigomanhaes/itchy"));
	}
	
	@Test
	public void findLinksByHref() {
		List<Element> elements = browser.findLinksByHref("https://github.com/rodrigomanhaes/itchy");
		assertThat(elements.size(), equalTo(1));
		assertThat(elements.get(0).content(), equalTo("Itchy Home"));
	}

}
