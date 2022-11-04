package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Frames {

    static WebDriver driver;

    @Test
    public static void main(String[] args) {
        // Demoqa.com
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demoqa.com/frames");

        driver.switchTo().frame("frame1");
        WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));
        String text = sampleHeading.getText();
        System.out.println(text);

        driver.switchTo().parentFrame();
        WebElement parentFrame = driver.findElement(By.xpath("//*[@id='framesWrapper']/div[1]"));
        String text1 = parentFrame.getText();
        System.out.println(text1);

        driver.switchTo().frame("frame2");
        WebElement sampleHeading1 = driver.findElement(By.id("sampleHeading"));
        String text2 = sampleHeading1.getText();
        System.out.println(text2);


    }
}
