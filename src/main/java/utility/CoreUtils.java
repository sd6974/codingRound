package utility;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CoreUtils extends ConfigFileReader {

	ConfigFileReader config = new ConfigFileReader();

	WebDriver getDriver = DriverFactory.getBrowser("Chrome");

	public WebElement find_element_xpath(String xpath) {

		return getDriver.findElement(By.xpath(xpath));

	}

	public WebElement find_element_id(String id) {

		return getDriver.findElement(By.id(id));

	}
	
	
	
	public WebElement find_element_linkText(String link) {

		return getDriver.findElement(By.linkText(link));

	}

	public void selectaValue(String val, String xpath) {
		Select select = new Select(find_element_xpath(xpath));
		for (int i = 0; i < select.getOptions().size(); i++) {
			if (select.getFirstSelectedOption().getText().equals(val)) {
				select.selectByVisibleText(val);

			}
		}

	}

	public void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
	}

	public boolean isElementPresent(By by) {
		try {
			getDriver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void launch_url() {
		System.out.println("URL:"
				+ config.properties.getProperty("FlightBookingURL"));
		getDriver.get(config.properties.getProperty("FlightBookingURL"));
	}

	public List<WebElement> find_elements_id(String id) {

		return getDriver.findElements(By.id(id));

	}

	public void window_maximize() {
		getDriver.manage().window().maximize();
	}

	public List<WebElement> find_elements_xpath(String xpath) {

		return getDriver.findElements(By.xpath(xpath));

	}

	public List<WebElement> find_elements_tagName(String id, String tag) {

		return getDriver.findElement(By.id(id)).findElements(By.tagName(tag));

	}

	public List<WebElement> find_elements_tagName_xpath(String xpath, String tag) {

		return getDriver.findElement(By.xpath(xpath)).findElements(
				By.tagName(tag));

	}

	public void quitDriver() {
		getDriver.quit();

	}
	
	public void switch_to_frame(String frameId){
		getDriver.switchTo().frame(frameId);
	}
}
