package PraticeAutomationTesting.address;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class TesteAddress extends BaseTestAddress{
    public static Faker faker = new Faker();

    public void abrirEditarEnderecoCobranca(){
        driver.findElement(By.cssSelector("[href=\"https://practice.automationtesting.in/my-account/edit-address/billing]")).click();
    }
    @Test
    public void testarEditarEnderecoCobracaRemoverNome(){
        abrirEditarEnderecoCobranca();
        driver.findElement(By.name("billing_first_name")).click();
        driver.findElement(By.name("billing_first_name")).clear();
        driver.findElement(By.name("save_addresss")).click();
        String error = driver.findElement(By.cssSelector("ul.woocommerce-error>li")).getText();
        Assert.assertTrue(error.contains("required"));
    }

    @Test
    public void testarEditarEnderecoCobracaRemoverSobrenome(){
        abrirEditarEnderecoCobranca();
        driver.findElement(By.name("billing_last_name")).click();
        driver.findElement(By.name("billing_last_name")).clear();
        driver.findElement(By.name("save_addresss")).click();
        String error = driver.findElement(By.cssSelector("ul.woocommerce-error>li")).getText();
        Assert.assertTrue(error.contains("required"));
    }
    @Test
    public void testarEditarEnderecoCobracaRemoverEmail(){
        abrirEditarEnderecoCobranca();
        driver.findElement(By.name("billing_email")).click();
        driver.findElement(By.name("billing_email")).clear();
        driver.findElement(By.name("save_addresss")).click();
        String error = driver.findElement(By.cssSelector("ul.woocommerce-error>li")).getText();
        Assert.assertTrue(error.contains("required"));
    }
    @Test
    public void testarEditarEnderecoCobracaRemoverTelefone(){
        abrirEditarEnderecoCobranca();
        driver.findElement(By.name("billing_phone")).click();
        driver.findElement(By.name("billing_phone")).clear();
        driver.findElement(By.name("save_addresss")).click();
        String error = driver.findElement(By.cssSelector("ul.woocommerce-error>li")).getText();
        Assert.assertTrue(error.contains("required"));
    }
    @Test
    public void testarEditarEnderecoCobracaRemoverEndereco(){
        abrirEditarEnderecoCobranca();
        driver.findElement(By.name("billing_address_1")).click();
        driver.findElement(By.name("billing_address_1")).clear();
        driver.findElement(By.name("save_addresss")).click();
        String error = driver.findElement(By.cssSelector("ul.woocommerce-error>li")).getText();
        Assert.assertTrue(error.contains("required"));
    }

    @Test
    public void testarEditarEnderecoMudarNome(){
        abrirEditarEnderecoCobranca();
        driver.findElement(By.name("billing_first_name")).click();
        driver.findElement(By.name("billing_first_name")).clear();
        driver.findElement(By.name("billing_first_name")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("save_addresss")).click();
        String message = driver.findElement(By.className("woocommerce-message")).getText();
        Assert.assertTrue(message.contains("Address changed successfully"));
    }

    @Test
    public void testarEditarEnderecoMudarSobrenome(){
        abrirEditarEnderecoCobranca();
        driver.findElement(By.name("billing_last_name")).click();
        driver.findElement(By.name("billing_last_name")).clear();
        driver.findElement(By.name("billing_last_name")).sendKeys(faker.name().lastName());
        driver.findElement(By.name("save_addresss")).click();
        String message = driver.findElement(By.className("woocommerce-message")).getText();
        Assert.assertTrue(message.contains("Address changed successfully"));
    }

    @Test
    public void testarEditarEnderecoMudarTelefone(){
        abrirEditarEnderecoCobranca();
        driver.findElement(By.name("billing_phone")).click();
        driver.findElement(By.name("billing_phone")).clear();
        driver.findElement(By.name("billing_phone")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.name("save_addresss")).click();
        String message = driver.findElement(By.className("woocommerce-message")).getText();
        Assert.assertTrue(message.contains("Address changed successfully"));
    }

    @Test
    public void testarEditarEnderecoMudarCompanhia(){
        abrirEditarEnderecoCobranca();
        driver.findElement(By.name("billing_company")).click();
        driver.findElement(By.name("billing_company")).clear();
        driver.findElement(By.name("billing_company")).sendKeys(faker.company().name());
        driver.findElement(By.name("save_addresss")).click();
        String message = driver.findElement(By.className("woocommerce-message")).getText();
        Assert.assertTrue(message.contains("Address changed successfully"));
    }

    @Test
    public void testarEditarEnderecoMudarEndereco(){
        abrirEditarEnderecoCobranca();
        driver.findElement(By.name("billing_address_1")).click();
        driver.findElement(By.name("billing_address_1")).clear();
        driver.findElement(By.name("billing_address_1")).sendKeys(faker.address().streetAddress());
        driver.findElement(By.name("billing_address_2")).click();
        driver.findElement(By.name("billing_address_2")).clear();
        driver.findElement(By.name("billing_address_2")).sendKeys(faker.address().buildingNumber());
        driver.findElement(By.name("save_addresss")).click();
        String message = driver.findElement(By.className("woocommerce-message")).getText();
        Assert.assertTrue(message.contains("Address changed successfully"));
    }

}
