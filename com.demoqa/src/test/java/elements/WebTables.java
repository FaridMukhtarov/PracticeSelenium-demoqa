package elements;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class WebTables {

    WebDriver driver;

    @Test
    public void main(String[] args) {
        // Demoqa.com
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demoqa.com/webtables");

        WebElement pageVisibli = driver.findElement(By.xpath("//div[text()='Web Tables']"));
        boolean page = pageVisibli.isDisplayed();
        System.out.println(page);

        WebElement addNewRecordButton = driver.findElement(By.id("addNewRecordButton"));
        addNewRecordButton.click();

        Actions actinon = new Actions(driver);
        WebElement firstName = driver.findElement(By.id("firstName"));
        actinon.click(firstName)
                .sendKeys("Farid")
                .sendKeys(Keys.TAB)
                .sendKeys("Mukhtarov")
                .sendKeys(Keys.TAB)
                .sendKeys("farid123@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("27")
                .sendKeys(Keys.TAB)
                .sendKeys("2500")
                .sendKeys(Keys.TAB)
                .sendKeys("IT")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(firstName));

        WebElement searchBox = driver.findElement(By.id("searchBox"));
        searchBox.sendKeys("Farid");
        WebElement visibly = driver.findElement(By.xpath("//div[@class='rt-tr -odd']"));
        System.out.println(visibly.getText());
        WebElement delete = driver.findElement(By.id("delete-record-4"));
        delete.click();

        WebElement noRowsFound = driver.findElement(By.xpath("//div[text()='No rows found']"));
        boolean noRows = noRowsFound.isDisplayed();
        String actualResult = noRowsFound.getText();
        String expectedResult = "No rows found";
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println(actualResult);

        driver.close();





    }
}
