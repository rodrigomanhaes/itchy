package itchy;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser {
	private RemoteWebDriver driver;
	
	public Browser() {
		driver = new FirefoxDriver();
	}

	public void visit(String exampleUrl) {
		driver.get(exampleUrl);
	}
 
	public String title() {
		return driver.getTitle();
	}
	
	public String html() {
		return driver.getPageSource();
	}
	
	public List<Element> findByCSS(String selector) {
		List<Element> elements = new LinkedList<Element>();
		for (WebElement element: driver.findElementsByCssSelector(selector))
			elements.add(new Element(element));
		return elements;
	}
	
	public List<Element> findByXPath(String selector) { 
		List<Element> elements = new LinkedList<Element>();
		for (WebElement element: driver.findElementsByXPath(selector))
			elements.add(new Element(element));
		return elements;
	}
	
	public void quit() {
		driver.quit();
	}
}