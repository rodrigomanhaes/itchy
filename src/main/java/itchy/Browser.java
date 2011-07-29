package itchy;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
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
	
	public List<Element> findByTag(String tag) {
		List<Element> elements = new LinkedList<Element>();
		for (WebElement element: driver.findElementsByTagName(tag))
			elements.add(new Element(element));
		return elements;
	}
	
	public Element findById(String id) {
		try {
			return new Element(driver.findElementById(id));
		}
		catch (NoSuchElementException e) {
			return null;
		}
	}
	
	public List<Element> findByName(String name) {
		List<Element> elements = new LinkedList<Element>();
		for (WebElement element: driver.findElementsByName(name))
			elements.add(new Element(element));
		return elements;
	}
	
	public List<Element> findLinksByText(String text) {
		List<Element> elements = new LinkedList<Element>();
		for (WebElement element: driver.findElementsByLinkText(text))
			elements.add(new Element(element));
		return elements;
	}
	
	public List<Element> findLinksByHref(String href) {
		List<Element> elements = new LinkedList<Element>();
		for (WebElement element: driver.findElementsByXPath("//a[@href=\"" + href + "\"]"))
			elements.add(new Element(element));
		return elements;
	}
	
	public boolean isTextPresent(String text) {
		return findByTag("body").get(0)
				.content()
				.replaceAll("\\s+", " ") // remove extra spaces
				.contains(text);
	}
	
	public void fill(String selector, String text) {
		Element element = findElementBySelector(selector);
		if (element != null)
			element.fill(text);
		else
			throw new ElementNotFoundException("There is no input element having \"" + 
												 selector + "\" as its id, name or label");
	}
	
	private Element findElementBySelector(String selector) {
		Element element = findById(selector);
		List<Element> found = null;
		if (element != null)
			return element;
		else {
			found = findByName(selector);
			if (found.size() > 0)
				return found.get(0);
			else 
				return findByLabelText(selector);
		}
	}
	
	private Element findByLabelText(String labelText) {
		List<Element> elements = findByXPath("id(//label[text()=\"" + labelText + "\"]/@for)");
		if (elements.isEmpty())
			return null;
		return elements.get(0);
	}
	
	public void choose(String name, String value) {
		List<Element> radioButtons = findByName(name);
		Element radio = null;
		for (Element element: radioButtons) {
			if (value.equals(element.value())) {
				radio = element;
				break;
			}
		}
		if (radio != null)
			radio.choose();
		else
			throw new ElementNotFoundException("There is no radio button having \"" + name + 
				"\" as name and \"" + value + "\" as value.");
	}
	
	public void choose(String label) {
		Element radio = findByLabelText(label);
		if (radio != null)
			radio.choose();
		else
			throw new ElementNotFoundException("There is no radio button having \"" + label + "\" as label.");
	}
	
	public List<Element> findOptionByValue(String value) { 
		return findByXPath("//option[@value='" + value + "']");
	}
	
	public List<Element> findOptionByText(String text) {
		return findByXPath("//option[text()='" + text + "']");
	}
	
	public void quit() {
		driver.quit();
	}

	public void select(String selector, String optionText) {
		Element select = findElementBySelector(selector);
		Element option = null;
		if (select.id() != null && !select.id().equals(""))
			option = findByXPath("//select[@id='" + select.id() + "']/option[text()='" + optionText + "']").get(0);
		else
			option = findByXPath("//select[@name='" + select.name() + "']/option[text()='" + optionText + "']").get(0);
		option.select();
	}
}