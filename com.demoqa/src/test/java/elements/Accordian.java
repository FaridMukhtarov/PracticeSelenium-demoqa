package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Accordian {
    static WebDriver driver;

    @Test
    public static void main(String[] args) {
        // Demoqa.com
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/accordian");

        WebElement accordian = driver.findElement(By.xpath("//div[text()='Accordian']"));
        System.out.println(accordian.isDisplayed());

        WebElement text = driver.findElement(By.xpath("//*[@id='section1Content']/p"));
        System.out.println(text.getText());

        WebElement closAndOpen = driver.findElement(By.xpath("//div[@class='accordion']/div [1]/div[2]"));
        String open = closAndOpen.getAttribute("class");
        System.out.println(open);

        WebElement section1Heading = driver.findElement(By.id("section1Heading"));
        section1Heading.click();
        open = closAndOpen.getAttribute("class");
        System.out.println(open);

        WebElement section3Heading = driver.findElement(By.id("section3Heading"));
        section3Heading.click();

        driver.quit();


    }
}
