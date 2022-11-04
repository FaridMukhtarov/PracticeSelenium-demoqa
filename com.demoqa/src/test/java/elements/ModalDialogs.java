package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;

public class ModalDialogs {
    static WebDriver driver;

    @Test
    public static void main(String[] args) {
        // Demoqa.com
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/modal-dialogs");

        WebElement seeModal = driver.findElement(By.xpath("//div[text()='Click on button to see modal']"));
        Assert.assertTrue(seeModal.isDisplayed());
        System.out.println(seeModal.isDisplayed());

        // Small Modal
        WebElement showSmallModal = driver.findElement(By.id("showSmallModal"));
        showSmallModal.click();
        WebElement smallModal = driver.findElement(By.xpath("//div[text()='Small Modal']"));
        Assert.assertTrue(smallModal.isDisplayed());
        System.out.println(smallModal.isDisplayed());

        WebElement modalBody = driver.findElement(By.cssSelector("div.modal-body"));
        System.out.println(modalBody.getText());

        WebElement closeSmallModal = driver.findElement(By.id("closeSmallModal"));
        closeSmallModal.click();

        // Large Modal
        WebElement showLargeModal = driver.findElement(By.id("showLargeModal"));
        showLargeModal.click();
        WebElement largeModal = driver.findElement(By.cssSelector("div.modal-title"));
        Assert.assertTrue(largeModal.isDisplayed());
        System.out.println(largeModal.isDisplayed());

        WebElement modalBodyLarge = driver.findElement(By.cssSelector("div.modal-body p"));
        System.out.println(modalBodyLarge.getText());

        WebElement closeLargeModal = driver.findElement(By.id("closeLargeModal"));
        closeLargeModal.click();

        driver.quit();
    }
}
