package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddPopup {

    WebDriver driver;

    public AddPopup(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "firstName")
    WebElement firstNameField;
    @FindBy(id = "lastName")
    WebElement lastNameField;
    @FindBy(id = "dependants")
    WebElement dependantsField;
    @FindBy(id = "addEmployee")
    WebElement addEmployeeButton;
    @FindBy(id= "updateEmployee")
    WebElement updateEmployeeButton;
    @FindBy(xpath = "//*[@id='employeeModal']/div/div/div[3]/button[3]")
    WebElement cancelButton;

    public void setFirstName(String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(cancelButton));

        firstNameField.click();
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }
    public void setLastName(String lastName) {
        lastNameField.click();
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }
    public void setDependants(String dependants) {
        dependantsField.click();
        dependantsField.clear();
        dependantsField.sendKeys(dependants);
    }
    public void clickAddButton() {
        addEmployeeButton.click();
        System.out.println("Employee has been added");
        driver.navigate().refresh();
    }
    public void clickUpdateButton() {
        updateEmployeeButton.click();
        System.out.println("Employee has been updated");
        driver.navigate().refresh();
    }

}
