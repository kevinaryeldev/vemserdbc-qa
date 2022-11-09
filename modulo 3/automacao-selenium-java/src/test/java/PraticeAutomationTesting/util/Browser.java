package PraticeAutomationTesting.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class Browser {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public void browserUp(String url){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        /*
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Workspace\\AdBlock.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        */
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,5);
        driver.get(url);
        driver.manage().window().maximize();
    }
    public static void browserDown(){
        driver.quit();
    }

}
