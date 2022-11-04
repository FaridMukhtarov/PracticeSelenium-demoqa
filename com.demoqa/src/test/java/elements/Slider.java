package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Slider {
    WebDriver driver;

    @Test
    public void slider() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/slider");
        driver.manage().window().maximize();

        WebElement slider = driver.findElement(By.cssSelector("input[type='range']"));

        Actions action = new Actions(driver);
        action.dragAndDropBy(slider, 20,0).perform();

        WebElement valueUnderSlider = driver.findElement(By.className("range-slider__tooltip__label"));
        String value = valueUnderSlider.getText();
        System.out.println("Recent value:" + value);

        WebElement sliderValue = driver.findElement(By.id("sliderValue"));
        String  sliderValueText = sliderValue.getAttribute("value");
        System.out.println("Slider value:" + sliderValueText);

        Assert.assertEquals(value, sliderValueText, "Values are not equal");


    }
}
