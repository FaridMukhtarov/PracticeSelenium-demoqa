package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class RadioButton {

    WebDriver driver;

    @Test
    public void test_1() throws InterruptedException {
        // Demoqa.com
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demoqa.com/radio-button");

        WebElement pageVisibly = driver.findElement(By.xpath("//div[text()='Do you like the site?']"));
        Assert.assertTrue(pageVisibly.isDisplayed());
        System.out.println(pageVisibly.getText());

        WebElement yesRadio = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        boolean isEnabled = yesRadio.isEnabled();
        System.out.println(isEnabled);

        if(isEnabled){
            yesRadio.click();
            System.out.println("Cliecked yesRadio Button");
        }

        WebElement yesRadioId = driver.findElement(By.id("yesRadio"));
        boolean isSelected = yesRadioId.isSelected();
        System.out.println(isSelected);

        if(isSelected){
            System.out.println("Yes Radio Button is Selected");
        }

        WebElement selected = driver.findElement(By.cssSelector("p.mt-3"));
        boolean isDisplayed = selected.isDisplayed();
        if (isDisplayed){
            System.out.println(selected.getText());
        }

        //Assert.assertTrue(selected.isDisplayed());

        driver.close();


    }
}
