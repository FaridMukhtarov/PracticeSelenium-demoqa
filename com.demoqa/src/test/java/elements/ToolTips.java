package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ToolTips {
    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void tool() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/tool-tips");
        driver.manage().window().maximize();

        WebElement toolTipButton = driver.findElement(By.id("toolTipButton"));
        Actions action = new Actions(driver);
        action.moveToElement(toolTipButton).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tooltip-inner")));

        WebElement toolTip = driver.findElement(By.className("tooltip-inner"));
        System.out.println(toolTip.getText());

    }
}
