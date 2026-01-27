package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "Username")
    WebElement usernameField;
    @FindBy(id = "Password")
    WebElement passwordField;
    @FindBy(xpath = "/html/body/div/main/div/div/form/button")
    WebElement loginButton;

    public void setUsername(String username) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(usernameField));

        usernameField.click();
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    public void setPassword(String password) {
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickLoginButton() {
        loginButton.click();
    }


}
