package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindows {

    static WebDriver driver;

    @Test
    public static void main(String[] args) {
        // Demoqa.com
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demoqa.com/browser-windows");

        WebElement newTab = driver.findElement(By.id("tabButton"));
        newTab.click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println(tabs.size());

        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getCurrentUrl());

        WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));
        System.out.println(sampleHeading.getText());

        //driver.close();


    }
}
