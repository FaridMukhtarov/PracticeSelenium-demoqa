package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;


public class BrokenLinksAndImages {

    WebDriver driver;

    @Test
    public void modals () throws IOException {
        // Demoqa.com
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demoqa.com/broken");

        // Valid And Broken Images
        WebElement validImage = driver.findElement(By.xpath("//div/img[1]"));
        String validImageUrl = validImage.getAttribute("src");
        System.out.println(validImageUrl);

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(validImageUrl);
        HttpResponse response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(statusCode);
        
        if(statusCode == 200){
            System.out.println("Valid Image:");
        }else if (statusCode == 500){
            System.out.println("Broken Image:");
        }


//        // Broken link And Valid Link
//        HttpClient client = HttpClientBuilder.create().build();
//        HttpGet request = new HttpGet("https://demoqa.com/"); // "http://the-internet.herokuapp.com/status_codes/500"
//        HttpResponse response = client.execute(request);
//        int statusCode = response.getStatusLine().getStatusCode();
//        System.out.println(statusCode);




    }
}
