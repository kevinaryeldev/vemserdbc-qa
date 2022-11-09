package PraticeAutomationTesting.loginLogout;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class TesteLoginLogout extends BaseTestLoginLogout {
    public static Faker faker = new Faker();

    @Test
    public void testarRegistroSemPreencherCampos(){
        driver.findElement(By.cssSelector("[name=register]")).click();
        String errorMessagee = driver.findElement(By.cssSelector("ul.woocommerce-error>li")).getText();
        Assert.assertTrue(errorMessagee.contains("Error"));
    }

    @Test
    public void testarRegistroSemPreencherSenha(){
        driver.findElement(By.id("reg_email")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.cssSelector("[name=register]")).click();
        String errorMessagee = driver.findElement(By.cssSelector("ul.woocommerce-error>li")).getText();
        Assert.assertTrue(errorMessagee.contains("Error"));
    }

    @Test
    public void testarRegistroPreenchendoSenhaFraca(){
        driver.findElement(By.id("reg_password")).sendKeys(faker.internet().password(4,7));
        boolean statusButton = driver.findElement(By.cssSelector("[name=register]")).isEnabled();
        Assert.assertTrue(statusButton == false);
    }

    @Test
    public void testarRegistroPreenchendoEmailSenhaValidos(){
        driver.findElement(By.id("reg_email")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("reg_password")).sendKeys(faker.internet()
                .password(7,14,true,true,true));
        driver.findElement(By.cssSelector("[name=register]")).click();
        String wellcomeMessage = driver.findElement(By.cssSelector
                ("div.woocommerce-MyAccount-content>p:nth-child(1)")).getText();
        Assert.assertTrue(wellcomeMessage.contains("Hello"));
    }
    @Test
    public void testarLoginSemPreencherCampos(){
        driver.findElement(By.cssSelector("[name=login]")).click();
        String errorMessagee = driver.findElement(By.cssSelector("ul.woocommerce-error>li")).getText();
        Assert.assertTrue(errorMessagee.contains("Error"));
    }
    @Test
    public void testarLoginSemPreencherSenha(){
        driver.findElement(By.id("username")).sendKeys(faker.name().username());
        driver.findElement(By.cssSelector("[name=login]")).click();
        String errorMessagee = driver.findElement(By.cssSelector("ul.woocommerce-error>li")).getText();
        Assert.assertTrue(errorMessagee.contains("Error"));
    }
    @Test
    public void testarLoginPreenchendoDadosInvalidos(){
        driver.findElement(By.id("username")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("password")).sendKeys(faker.internet().password(7,10));
        driver.findElement(By.cssSelector("[name=login]")).click();
        String errorMessagee = driver.findElement(By.cssSelector("ul.woocommerce-error>li")).getText();
        Assert.assertTrue(errorMessagee.contains("Error"));
    }
    @Test
    public void testarLoginPreencherUserValidoSenhaInvalida(){
        driver.findElement(By.id("username")).sendKeys(validEmail);
        driver.findElement(By.id("password")).sendKeys(faker.internet().password(7,10));
        driver.findElement(By.cssSelector("[name=login]")).click();
        String errorMessagee = driver.findElement(By.cssSelector("ul.woocommerce-error>li")).getText();
        Assert.assertTrue(errorMessagee.contains("Error"));
    }

    @Test
    public void testarLoginValido(){
        driver.findElement(By.id("username")).sendKeys(validEmail);
        driver.findElement(By.id("password")).sendKeys(validPassword);
        driver.findElement(By.cssSelector("[name=login]")).click();
        String wellcomeMessage = driver.findElement(By.cssSelector
                ("div.woocommerce-MyAccount-content>p:nth-child(1)")).getText();
        Assert.assertTrue(wellcomeMessage.contains("Hello"));
    }
}
