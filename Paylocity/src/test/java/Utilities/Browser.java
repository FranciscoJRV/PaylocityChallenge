package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Browser {

    public static WebDriver StartBrowser(WebDriver driver, String URL) {
        System.setProperty("webdriver.chrome.driver","C:\\Browser Drivers\\chromedriver.exe");
        //In the previous line set the path to your ChromeDriver executable

        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
    public static void closeBrowser(WebDriver driver) {
        driver.quit();
    }
}
