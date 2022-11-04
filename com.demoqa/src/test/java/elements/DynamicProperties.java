package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicProperties {

    static WebDriver driver;

    @Test
    public  void main(String[] args) {

        // Demoqa.com
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demoqa.com/dynamic-properties");

        // Dynamic PropertiesDynamic Properties
        WebElement header = driver.findElement(By.cssSelector(".main-header"));
        boolean headerPage = header.isDisplayed();
        String actualResult = header.getText();
        String expectedResult = "Dynamic Properties";
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println(actualResult);

        // This text has random ID
        WebElement hasRandomId = driver.findElement(By.xpath("//p[text()='This text has random Id']"));
        String forSystem = hasRandomId.getText();
        Assert.assertTrue(hasRandomId.isDisplayed());
        System.out.println(forSystem);

        // Will enable 5 seconds
        WebElement enableAfter = driver.findElement(By.id("enableAfter"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(enableAfter));
        enableAfter.click();
        System.out.println(enableAfter.getText());

        // Color Change Befor
        WebElement colorChange = driver.findElement(By.id("colorChange"));
        String className = colorChange.getAttribute("class");
        System.out.println("Before Change:" +className);

        WebDriverWait waitColor = new WebDriverWait(driver, Duration.ofSeconds(6));
        waitColor.until(ExpectedConditions.attributeToBe(colorChange, "class", "mt-4 text-danger btn btn-primary"));
        className = colorChange.getAttribute("class");
        System.out.println("After Change:" + className);

        // Visible After 5 Seconds
        WebDriverWait waitVisible = new WebDriverWait(driver,Duration.ofSeconds(5));
        waitVisible.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        WebElement visibleAfter = driver.findElement(By.id("visibleAfter"));
        visibleAfter.click();
        System.out.println(visibleAfter.getText());




    }
}
