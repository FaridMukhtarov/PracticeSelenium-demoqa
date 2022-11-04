package elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class Download {

    static WebDriver driver;

    @Test
    public static void main(String[] args) throws InterruptedException {

        // Demoqa.com
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demoqa.com/upload-download");

        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        downloadButton.click();

        String path = "C:/Users/farid/Downloads";
        String fileName = "sampleFile.jpeg";
        Thread.sleep(5000);
        boolean isDownloaded = isFileDownloaded(path,fileName);
        System.out.println(isDownloaded);
    }
    public static boolean isFileDownloaded(String downloadPath, String fileName){
        File file = new File(downloadPath);
        File[] files = file.listFiles();

        for (int i = 0; i < files.length; i++){
            if(files[1].getName().equals(fileName)){
                files[1].delete();
                return true;
            }
        }
        return false;
    }
}
