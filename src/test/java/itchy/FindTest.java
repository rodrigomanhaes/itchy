package itchy;

import static itchy.ItchySuite.browser;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import itchy.testsupport.FakeApp;

import java.util.List;

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
		assertThat(forms.size(), is(2));
		assertThat(forms.get(0).id(), equalTo("firstForm"));
		assertThat(forms.get(1).id(), equalTo("secondForm"));
	}
}
