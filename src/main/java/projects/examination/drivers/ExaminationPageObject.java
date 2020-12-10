package projects.examination.drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ExaminationPageObject {

    private WebDriver webDriver;

    public ExaminationPageObject(WebDriver webDriver) {
        this.webDriver = webDriver;

        PageFactory.initElements(webDriver, this);
    }

    public WebElement firstBugNameCell() {
        try {
           return webDriver.findElement(By.xpath("//div[contains(text(), 'First Bug')]"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public String getFirstBugText() {
        try {
            return webDriver.findElement(By.xpath("//div[contains(text(), 'First Bug')]")).getText();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public WebElement addFormButton() {
        try {
           return webDriver.findElement(By.xpath("//span[contains(text(), 'Add in form')]"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public WebElement nameFieldForm() {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']")));
            return webDriver.findElement(By.xpath("//input[@name='name']"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public WebElement notesFieldForm() {
        try {
            return webDriver.findElement(By.xpath("//textarea[@name='notes']"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
}

    public WebElement okButton() {
        try {
            return webDriver.findElement(By.xpath("//span[contains(text(), 'OK')]"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public WebElement myBugNameCell() {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Bug For Roman')]")));
            return webDriver.findElement(By.xpath("//div[contains(text(), 'Bug For Roman')]"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public String getMyBugName() {
        try {
            return webDriver.findElement(By.xpath("//div[contains(text(), 'Bug For Roman')]")).getText();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public WebElement deleteButton() {
        try {
            return webDriver.findElement(By.id("button-1045"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public WebElement confirmDeleteButton() {
        try {
            return webDriver.findElement(By.xpath("//span[contains(text(), 'Yes')]"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public WebElement addButton() {
        try{
            List<WebElement> buttons = webDriver.findElements(By.xpath("//span[contains(text(), 'Add')]"));
            return  buttons.get(0);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public WebElement applyButton() {
        try{
            return  webDriver.findElement(By.xpath("//span[contains(text(), 'Apply')]"));
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

}
