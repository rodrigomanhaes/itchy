package itchy;

import org.openqa.selenium.WebElement;

public class Element {

	private WebElement webElement;
	
	public Element(WebElement element) {
		this.webElement = element;
	}
	
	public String name() {
		return this.webElement.getAttribute("name");
	}
	
	public String id() {
		return this.webElement.getAttribute("id");
	}
	
	public String attr(String attributeName) {
		return this.webElement.getAttribute(attributeName);
	}
}
