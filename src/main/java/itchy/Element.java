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
	
	public String value() {
		return attr("value");
	}
	
	public String content() {
		return this.webElement.getText();
	}
	
	public String attr(String attributeName) {
		return this.webElement.getAttribute(attributeName);
	}
	
	public void fill(String text) {
		this.webElement.sendKeys(text);
	}
	
	public boolean isChecked() {
		return attr("checked") != null;
	}
	
	public boolean isChosen() {
		return isChecked();
	}
	
	public void choose() {
		this.webElement.click();
	}
}
