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

}
