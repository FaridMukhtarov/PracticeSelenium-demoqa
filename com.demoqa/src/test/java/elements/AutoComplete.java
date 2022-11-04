package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
    public class AutoComplete {

        WebDriver driver;

        @Test
        public void auto() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://demoqa.com/auto-complete");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            WebElement input = driver.findElement(By.id("autoCompleteSingleInput"));
            input.sendKeys("R");

            List<WebElement> suggestions = driver.findElements(By.cssSelector("div.auto-complete__option"));
            for (WebElement suggestion : suggestions){
                String text = suggestion.getText();
                System.out.println(text);

                if(text.equalsIgnoreCase("green")){
                    suggestion.click();
                    break;
                }
            }
           // suggestions.get(0).click();




        }
}
