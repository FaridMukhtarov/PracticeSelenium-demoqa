package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class NestedFrames {

    static WebDriver driver;

    @Test
    public static void main(String[] args) {
        // Demoqa.com
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/nestedframes");
        driver.switchTo().frame("frame1");

        // Parent Frame
        WebElement parentFrame = driver.findElement(By.xpath("//body[text()='Parent frame']"));
        String text = parentFrame.getText();
        System.out.println(text);

        // Child Frame
        driver.switchTo().frame(0);
        WebElement childFrame = driver.findElement(By.xpath("//p[text()='Child Iframe']"));
        String text1 = childFrame.getText();
        System.out.println(text1);

        // Main Frame
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        WebElement mainFrame = driver.findElement(By.xpath("//*[@id='framesWrapper']/div[1]"));
        String text2 = mainFrame.getText();
        System.out.println(text2);


    }
}
