package PraticeAutomationTesting.loginLogout;

import PraticeAutomationTesting.util.Browser;
import org.junit.After;
import org.junit.Before;

public class BaseTestLoginLogout extends Browser {
    public String validEmail = "testqakevin@gmail.com";
    public String validPassword = "testqa123@";
    @Before
    public void openBrowser(){
        browserUp("https://practice.automationtesting.in/my-account/");
    }

    @After
    public void closeBrowser(){
        browserDown();
    }
}
