package PraticeAutomationTesting.address;

import PraticeAutomationTesting.util.Browser;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;

public class BaseTestAddress extends Browser {
    public String validEmail = "testqakevin@gmail.com";
    public String validPassword = "testqa123@";
    @Before
    public void openBrowser(){
        browserUp("https://practice.automationtesting.in/my-account/");
        fazerLogin();
        driver.findElement(By.cssSelector("li.woocommerce-MyAccount-navigation-link--edit-address> a")).click();
    }
    public void fazerLogin(){
        driver.findElement(By.id("username")).sendKeys(validEmail);
        driver.findElement(By.id("password")).sendKeys(validPassword);
        driver.findElement(By.cssSelector("[name=login]")).click();
    }

  //  @After
/*    public void closeBrowser(){
        browserDown();
    }

 */
}
