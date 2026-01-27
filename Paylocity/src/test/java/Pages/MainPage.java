package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {

    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id="add")
    WebElement addButton;
    @FindBy(xpath = "//*[@id='employeesTable']/tbody")
    WebElement employeesTable;


    public void clickAddButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(addButton));
        addButton.click();
    }

    public void clickEditIcon(String FirstName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(employeesTable));
        employeesTable.click();

        System.out.println("Tabla Found");

        List<WebElement> rows = employeesTable.findElements(By.tagName("tr"));
        int i = 0;

        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
             i++;
            if (columns.size() > 1) {
                String text = columns.get(1).getText();
                System.out.println("First Name: " + text);
                if (text.equalsIgnoreCase(FirstName)) {
                    System.out.println("Employee Found: " + text);
                    System.out.println("Row: " + i);
                    WebElement editIcon = driver.findElement(By.xpath("//*[@id='employeesTable']/tbody/tr[" + i + "]/td[9]/i[1]"));
                    editIcon.click();
                    break;
                }
            }
        }
    }

    public void clickDeleteIcon(String FirstName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(employeesTable));
        employeesTable.click();

        System.out.println("Tabla Found");

        List<WebElement> rows = employeesTable.findElements(By.tagName("tr"));
        int i = 0;

        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            i++;
            if (columns.size() > 1) {
                String text = columns.get(1).getText();
                System.out.println("First Name: " + text);
                if (text.equalsIgnoreCase(FirstName)) {
                    System.out.println("Employee found: " + text);
                    System.out.println("Row: " + i);
                    WebElement deleteIcon = driver.findElement(By.xpath("//*[@id='employeesTable']/tbody/tr[" + i + "]/td[9]/i[2]"));
                    deleteIcon.click();
                    WebElement confirmDeleteButton = driver.findElement(By.id("deleteEmployee"));
                    confirmDeleteButton.click();
                    System.out.println("Employee " + text + " Has been Deleted");
                    break;
                }
            }
        }
    }


}
