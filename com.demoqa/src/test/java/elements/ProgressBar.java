package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProgressBar {
    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void slider() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/progress-bar");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement startStopButton = driver.findElement(By.id("startStopButton"));
        startStopButton.click();

        WebElement progressBar = driver.findElement(By.cssSelector("div[role='progressbar']"));

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.pollingEvery(Duration.ofMillis(50));
//        wait.until(ExpectedConditions.attributeToBe(progressBar, "aria-valuenow", "50"));
//        startStopButton.click();

        wait.until(ExpectedConditions.attributeToBe(By.id("resetButton"), "id", "resetButton"));
        driver.findElement(By.id("resetButton")).click();



    }
}
