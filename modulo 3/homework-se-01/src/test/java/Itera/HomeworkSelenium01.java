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
import java.util.ArrayList;
import java.util.List;

public class HomeworkSelenium01 {
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
        driver.findElement(By.cssSelector("[href=\"/home/automation\"]")).click();
    }

    @Test
    public void validarPreencherTextAreaValidos(){
        driver.findElement(By.id("name")).sendKeys(faker.name().nameWithMiddle());
        driver.findElement(By.id("phone")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.id("email")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("password")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("address")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.cssSelector("[name=\"submit\"]")).click();
    }

    @Test
    public void validarPreencherTextAreaSemNome(){
        driver.findElement(By.id("phone")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.id("email")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("password")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("address")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.cssSelector("[name=\"submit\"]")).click();
    }

    @Test
    public void validarPreencherTextAreaSemSenha(){
        driver.findElement(By.id("name")).sendKeys(faker.name().nameWithMiddle());
        driver.findElement(By.id("phone")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.id("email")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("address")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.cssSelector("[name=\"submit\"]")).click();
    }

    @Test
    public void validarPreencherTextAreaSemEmail(){
        driver.findElement(By.id("name")).sendKeys(faker.name().nameWithMiddle());
        driver.findElement(By.id("phone")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.id("email")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("password")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("address")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.cssSelector("[name=\"submit\"]")).click();
    }

    @Test
    public void validarPreencherTextAreaEmailInvalido(){
        driver.findElement(By.id("name")).sendKeys(faker.name().nameWithMiddle());
        driver.findElement(By.id("phone")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.id("email")).sendKeys(faker.funnyName().name());
        driver.findElement(By.id("password")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("address")).sendKeys(faker.address().fullAddress());
        driver.findElement(By.cssSelector("[name=\"submit\"]")).click();
    }

    @Test
    public void validarPreencherRadioButtonAmbos(){
        String[] options1 ={"female","male"};
        driver.findElement(By.id(options1[faker.number().numberBetween(0,1)])).click();
        List<String> options2 = new ArrayList<>();
        options2.add("[id=monday]");
        options2.add("[id=tuesday]");
        options2.add("[id=wednesday]");
        options2.add("[id=thursday]");
        options2.add("[id=friday]");
        options2.add("[id=saturday]");
        options2.add("[id=sunday]");
        int quantidadeSeraEscolhida = faker.number().numberBetween(0,7);
        marcarCheckbox(options2,quantidadeSeraEscolhida);
    }

    @Test
    public void validarPreencherRadioButtonApenasRadio(){
        String[] options1 ={"female","male"};
        driver.findElement(By.id(options1[faker.number().numberBetween(0,1)])).click();
    }
    @Test
    public void validarPreencherRadioButtonApenasCheckbox(){
        List<String> options2 = new ArrayList<>();
        options2.add("[id=monday]");
        options2.add("[id=tuesday]");
        options2.add("[id=wednesday]");
        options2.add("[id=thursday]");
        options2.add("[id=friday]");
        options2.add("[id=saturday]");
        options2.add("[id=sunday]");
        int quantidadeSeraEscolhida = faker.number().numberBetween(0,7);
        marcarCheckbox(options2,quantidadeSeraEscolhida);
    }

    @Test
    public void testarFuncaoMarcarCheckbox(){
        List<String> options2 = new ArrayList<>();
        options2.add("[id=monday]");
        options2.add("[id=tuesday]");
        options2.add("[id=wednesday]");
        options2.add("[id=thursday]");
        options2.add("[id=friday]");
        options2.add("[id=saturday]");
        options2.add("[id=sunday]");
        marcarCheckbox(options2,7);
    }
    public void marcarCheckbox(List<String> selectors, int qnt){
        int escolhidos = 0;
        while (escolhidos < qnt){
            int escolhido = faker.number().numberBetween(0,selectors.size() -1);
            driver.findElement(By.cssSelector(selectors.get(escolhido))).click();
            escolhidos++;
            selectors.remove(escolhido);
        }
    }
    @Test
    public void validarSelecionarOpcaoDropdown(){
        driver.findElement(By.cssSelector("[class=\"custom-select\"]")).click();
        int value = faker.number().numberBetween(1,10);
        driver.findElement(By.cssSelector(retornarSeletorDropdown(value))).click();
    }

    @Test
    public void validarSelecionarOpcaoDropdownNenhuma(){
        driver.findElement(By.cssSelector("[class=\"custom-select\"]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[value=\"1\"]")));
        driver.findElement(By.cssSelector("[class=\"custom-select\"]")).click();
    }
    public String retornarSeletorDropdown(int value){
        return "[value=\""+value+"\"]";
    }
    @Test
    public void validarSelecionarCheckboxRadioXpathBoth(){
        int random = faker.number().numberBetween(0,3);
        String[] optionRadio = {"[for=\"1year\"]","[for=\"2years\"]","[for=\"3years\"]","[for=\"4years\"]"};
        driver.findElement(By.cssSelector(optionRadio[random])).click();
        List<String> optionCheckbox = new ArrayList<>();
        optionCheckbox.add("[for=\"selenium\"]");
        optionCheckbox.add("[for=\"cucumber\"]");
        optionCheckbox.add("[for=\"testng\"]");
        optionCheckbox.add("[for=\"serenity\"]");
        optionCheckbox.add("[for=\"testim\"]");
        optionCheckbox.add("[for=\"mabl\"]");
        int quantidadeSeraEscolhida = faker.number().numberBetween(0,6);
        marcarCheckbox(optionCheckbox,quantidadeSeraEscolhida);
    }
    /*
    @After
    public void fecharNavegador(){
        driver.quit();
    }

     */
}


