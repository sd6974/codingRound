import com.sun.javafx.PlatformUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import utility.ConfigFileReader;
import utility.CoreUtils;
import utility.DriverFactory;

import java.util.List;

public class FlightBookingTest extends CoreUtils {

    

//	WebDriver driver = new ChromeDriver();
	ConfigFileReader config = new ConfigFileReader();
	DriverFactory drivers;


    @Test
    public void testThatResultsAppearForAOneWayJourney() {

        //setDriverPath();
        launch_url();
         
         waitFor(2000);
         window_maximize();
        find_element_id("OneWay").click();

      
        find_element_id("FromTag").clear();
        find_element_id("FromTag").sendKeys("Bangalore");
        
        //wait for the auto complete options to appear for the origin

        waitFor(2000);
        System.out.println("SIZE::"+find_elements_tagName_xpath("//*[@id='ui-id-1']","li").size());
        find_element_id("FromTag").sendKeys(Keys.DOWN);
        //find_elements_tagName("ui-id-1","li").get(0).click();
        find_elements_tagName_xpath("//*[@id='ui-id-1']","li").get(0).click();
        find_elements_tagName_xpath("//*[@id='ui-id-1']","li").size();// find_elements_tagName("ui-id-1","li").get(0).click();
       // List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        //originOptions.get(0).click();
        
        find_element_id("ToTag").clear();
        find_element_id("ToTag").sendKeys("Delhi");

       // driver.findElement(By.id("toTag")).clear();
        //driver.findElement(By.id("toTag")).sendKeys("Delhi");

        //wait for the auto complete options to appear for the destination

        waitFor(2000);
        //select the first item from the destination auto complete list
       // List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
        //destinationOptions.get(0).click();
        waitFor(2000);
        System.out.println("SIZE::"+find_elements_tagName_xpath("//*[@id='ui-id-2']","li").size());
        find_element_id("ToTag").sendKeys(Keys.DOWN);
        
        find_elements_tagName_xpath("//*[@id='ui-id-2']","li").get(0).click();
        
        

      //  driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")).click();
       // find_element_xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a").click();
        find_element_id("DepartDate").click();
        find_element_id("DepartDate").sendKeys("27/11/2019");
        find_element_id("DepartDate").sendKeys(Keys.TAB);

        //all fields filled in. Now click on search
        //driver.findElement(By.id("SearchBtn")).click();
        find_element_id("SearchBtn").click();
        waitFor(9000);
        //verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent(By.className("searchSummary")));

        //close the browser
         
        DriverFactory.closeAllDriver();
        quitDriver();

    }


   

  /*  private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }*/
}
