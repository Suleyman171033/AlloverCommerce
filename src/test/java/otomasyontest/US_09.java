package otomasyontest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class US_09 {
    WebDriver driver;
    @BeforeEach
    public void setUp() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://allovercommerce.com/");
    }

    @Test
    public void tc_01() throws InterruptedException {
        WebElement register =driver.findElement(By.xpath("//span[text()='Register']"));
        register.click();

        driver.findElement(By.linkText("Become a Vendor")).click();


        driver.findElement(By.id("user_email")).sendKeys("tallan.triton@falkcia.com");
        driver.findElement(By.id("passoword")).sendKeys("1234Sa.");
        driver.findElement(By.id("confirm_pwd")).sendKeys("1234Sa.");
        WebElement register1=driver.findElement(By.id("wcfm_membership_register_button"));

        Thread.sleep(60000);
        register1.click();


         WebElement messagge = driver.findElement(By.xpath("(//h1)[2]"));
         String actualData=messagge.getText();
         String exceptedData="Welcome to Allover Commerce!";

         Assertions.assertEquals(exceptedData,actualData);




    }

    @Test
    public void test02() throws InterruptedException {

       WebElement register= driver.findElement(By.xpath("//span[text()='Register']"));
                register.click();

        driver.findElement(By.linkText("Become a Vendor")).click();
        driver.findElement(By.name("wcfm_email_verified_input")).sendKeys("12345");
        WebElement password=driver.findElement(By.id("passoword"));
        password.sendKeys("1234Sa.", Keys.TAB,"1234Sa.",Keys.ENTER);


       WebElement messagge=driver.findElement(By.xpath("//div[@class='wcfm-message wcfm-error']"));

       Thread.sleep(3000);

      Assertions.assertTrue(messagge.isDisplayed());







    }




}
