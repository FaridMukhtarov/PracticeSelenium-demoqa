package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alerts {

    static WebDriver driver;

    @Test
    public static void main(String[] args) {
        // Demoqa.com
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demoqa.com/alerts");

        WebElement mainHeader = driver.findElement(By.cssSelector(".main-header"));
        Assert.assertTrue(mainHeader.isDisplayed());
        System.out.println(mainHeader.getText());


        // Alert Button
        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.alertIsPresent());

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


        // Timer Alert Button
        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        timerAlertButton.click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait1.until(ExpectedConditions.alertIsPresent());

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


        // Confirm Button
        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait2.until(ExpectedConditions.alertIsPresent());

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();


        // Promt Button
        WebElement promtButton = driver.findElement(By.id("promtButton"));
        promtButton.click();

        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait3.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().sendKeys("Farid");
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();


    }
}
