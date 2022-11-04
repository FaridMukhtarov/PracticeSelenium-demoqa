package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public  class TextBox {

    WebDriver driver;

    @Test
    public void test () {

        // Demoqa.com
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demoqa.com/text-box");

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Farid");
        WebElement email = driver.findElement(By.cssSelector("input[placeholder='name@example.com']"));
        email.sendKeys("ferid123@gmail.com");
        WebElement currentAdd = driver.findElement(By.xpath("//textarea[@placeholder='Current Address']"));
        currentAdd.sendKeys("Baki, Azerbaycan");
        WebElement permanentAdd = driver.findElement(By.id("permanentAddress"));
        permanentAdd.sendKeys("Baku, Azerbaycan");
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        WebElement name = driver.findElement(By.id("name"));
        WebElement emailVisible = driver.findElement(By.cssSelector("p[id='email']"));
        WebElement current = driver.findElement(By.cssSelector("p[id='currentAddress']"));
        WebElement permanent = driver.findElement(By.cssSelector("p[id='permanentAddress']"));
        System.out.println(name.getText());
        System.out.println(emailVisible.getText());
        System.out.println(current.getText());
        System.out.println(permanent.getText());

        Assert.assertTrue(name.isDisplayed());





    }

}