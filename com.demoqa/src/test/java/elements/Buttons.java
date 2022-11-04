package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Buttons {

    WebDriver driver;

    @Test
    public  void main(String[] args) throws InterruptedException {
        // Demoqa.com
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demoqa.com/buttons");
        Actions actoin = new Actions(driver);

        // Double Click Me
        WebElement doubleClickMe = driver.findElement(By.id("doubleClickBtn"));
        actoin.doubleClick(doubleClickMe).perform();
        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        String actual = doubleClickMessage.getText();
        String doubleMessage = "You have done a double click";
        Assert.assertEquals(actual, doubleMessage);
        System.out.println(actual);

        // Right Click Me
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actoin.contextClick(rightClickBtn).perform();
        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        String rightClickMessageActual = rightClickMessage.getText();
        String rightClickMessageExpected = "You have done a right click";
        Assert.assertEquals(rightClickMessageActual, rightClickMessageExpected);
        System.out.println(rightClickMessageActual);

        // Dynamic Click Me
        WebElement dynamicClickMeBtt = driver.findElement(By.xpath("//button[text()='Click Me']"));
        dynamicClickMeBtt.click();
        WebElement dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage"));
        String dynamicClickMessageActual = dynamicClickMessage.getText();
        String dynamicClickMessageExpected = "You have done a dynamic click";
        Assert.assertEquals(dynamicClickMessageActual,dynamicClickMessageExpected);
        System.out.println(dynamicClickMessageActual);

        Thread.sleep(3000);
        driver.close();


    }
}
