package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DatePicker {
    WebDriver driver;

    @Test
    public void selectDate() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/date-picker");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement dateSelection = driver.findElement(By.id("datePickerMonthYearInput"));
        dateSelection.click();

        WebElement monthElement = driver.findElement(By.className("react-datepicker__month-select"));
        Select select = new Select(monthElement);
        select.selectByVisibleText("January");
        //select.selectByIndex(0);

        WebElement yearsElement = driver.findElement(By.className("react-datepicker__year-select"));
        select = new Select(yearsElement);
        select.selectByVisibleText("1995");

        List<WebElement> daysElement = driver.findElements(By.cssSelector("div.react-datepicker__day "));

        for (WebElement dayElement : daysElement) {
            //System.out.println(dayElement.getText());

            String text = dayElement.getText();
            if (text.equals("1")) {
                dayElement.click();
                break;

            }
        }

    }
}