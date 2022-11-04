package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBox {

    WebDriver driver;

    @Test
    public void test_1(){
        // Demoqa.com
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demoqa.com/checkbox");

        String checkBoxCssValue = "label[for='tree-node-home'] span.rct-checkbox svg";
        WebElement homeCheckBox = driver.findElement(By.cssSelector(checkBoxCssValue));
        homeCheckBox.click();

        homeCheckBox = driver.findElement(By.cssSelector(checkBoxCssValue));

        String homeCheckClassName = homeCheckBox.getAttribute("class");


        if (homeCheckClassName.equals("rct-icon rct-icon-check")){
            System.out.println("CheckBox is Checked!");

        }else{
            System.out.println("CheckBox is Unchecked!");

        }

        System.out.println(driver.findElement(By.id("result")).getText());

    }

}
