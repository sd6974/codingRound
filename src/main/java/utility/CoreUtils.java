package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CoreUtils {

	ConfigFileReader config = new ConfigFileReader();

	WebDriver getDriver = DriverFactory.getBrowser("Browser");

	public WebElement find_element_xpath(String xpath) {

		return getDriver.findElement(By.xpath(xpath));

	}

	public WebElement find_element_id(String id) {

		return getDriver.findElement(By.id(id));

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

}
