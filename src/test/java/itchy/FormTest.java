package itchy;

import static itchy.ItchySuite.browser;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import itchy.testsupport.FakeApp;

import org.junit.Before;
import org.junit.Test;

public class FormTest {
	@Before
	public void visitExamplePage() {
		browser.visit(FakeApp.EXAMPLE_URL);
	}

	@Test
	public void fillsFieldById() {
		browser.fill("secondTFId", "Value written by id");
		assertThat(browser.findById("secondTFId").value(), equalTo("Value written by id"));
	}
}
