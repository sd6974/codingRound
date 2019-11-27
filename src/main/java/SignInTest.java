
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utility.CoreUtils;

public class SignInTest extends CoreUtils {

    

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

       

    	launch_url();
        waitFor(2000);
        find_element_linkText("Your trips").click();
        find_element_id("SignIn").click();
        
        waitFor(6000);
      
        switch_to_frame("modal_window");
        find_element_id("signInButton").click();
        
        waitFor(5000);
        String errors1 = find_element_id("errors1").getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        quitDriver();
    }

   /* private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }
*/

}
