package Itera;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class PrimeiroTeste {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static Faker faker = new Faker();

    @Before
    public void abrirNavegador(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,5);
        driver.get("https://itera-qa.azurewebsites.net");
        driver.manage().window().maximize();
    }

    @Test
    public void validarLoginComUsernameSenhaValidos(){
        driver.findElement(By.cssSelector("[href=\"/Login\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("Username")).sendKeys("teste123");
        driver.findElement(By.id("Password")).sendKeys("12345");
        driver.findElement(By.cssSelector("[name=\"login\"]")).click();
    }
    @Test
    public void validarLoginComUsernameSenhaInValidos(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("[href=\"/Login\"]")).click();
        driver.findElement(By.id("Username")).sendKeys(faker.name().username());
        driver.findElement(By.id("Password")).sendKeys(faker.internet().password());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[name=\"login\"]")));
        driver.findElement(By.cssSelector("[name=\"login\"]")).click();
    }


    @Test
    public void validarCriacaoDeUserDadosValidos() {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("[href=\"/UserRegister/NewUser\"]")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.id("FirstName")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("Surname")).sendKeys(faker.name().lastName());
        driver.findElement(By.id("E_post")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("Mobile")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.id("Username")).sendKeys(faker.name().username());
        String password = faker.internet().password();
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
        driver.findElement(By.id("submit")).click();

    }
    @Test
    public void validarCriacaoDeUserSenhaConfirmacaoDiferentes(){
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("[href=\"/UserRegister/NewUser\"]")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.id("FirstName")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("Surname")).sendKeys(faker.name().lastName());
        driver.findElement(By.id("E_post")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("Mobile")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.id("Username")).sendKeys(faker.name().username());
        driver.findElement(By.id("Password")).sendKeys(faker.internet().password());
        driver.findElement(By.id("ConfirmPassword")).sendKeys(faker.internet().password());
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.findElement(By.id("submit")).click();
    }
}


