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
import java.util.concurrent.TimeUnit;

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
        String[] options2 = {"monday","tuesday","wednesday","thursday","friday","saturday","sunday"};
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
        String[] options2 = {"[id=monday]","[id=tuesday]","[id=wednesday]","[id=thursday]",
                "[id=friday]","[id=saturday]","[id=sunday]"};
        int quantidadeSeraEscolhida = faker.number().numberBetween(0,7);
        marcarCheckbox(options2,quantidadeSeraEscolhida);
    }

    public void marcarCheckbox(String[] ids, int qnt){
        int escolhidos = 0;
        List<Integer> jaEscolhidos = new ArrayList<Integer>();
        while (escolhidos < qnt){
            int escolhido = faker.number().numberBetween(0,ids.length-1);
            System.err.println(escolhido);
            if (jaEscolhidos.stream().noneMatch(el->el == escolhido)){
                driver.findElement(By.cssSelector(ids[escolhido])).click();
                escolhidos++;
                jaEscolhidos.add(escolhido);
            }
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
        String[] optionCheckBox = {"[for=\"1year\"]","[for=\"2years\"]","[for=\"3years\"]","[for=\"4years\"]"};
        driver.findElement(By.cssSelector(optionCheckBox[random])).click();
        String[] optionCheckbox = {"[for=\"selenium\"]","[for=\"cucumber\"]","[for=\"testng\"]","[for=\"serenity\"]","[for=\"mabl\"]","[for=\"testim\"]"};
        int quantidadeSeraEscolhida = faker.number().numberBetween(0,6);
        marcarCheckbox(optionCheckbox,quantidadeSeraEscolhida);
    }
    @After
    public void fecharNavegador(){
        driver.quit();
    }

}


