package projects.examination.tests;

import automation.infrastructure.base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import projects.examination.drivers.ExaminationPageObject;
import static org.junit.Assert.assertEquals;

public class ExaminationTest extends TestBase{

    ExaminationPageObject examinationWebsite;

    @Override
    protected void beforeTest() {
        examinationWebsite = new ExaminationPageObject(browser);

        logger.log("Open website");
        browser.get("http://autotesttask.herokuapp.com/");

        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'First Bug')]")));
    }

    @Test
    public void test1() {
        logger.log("Check if First bug Name Cell is present");
        Assert.assertTrue(examinationWebsite.firstBugNameCell().isDisplayed());

        logger.log("Check if First bug Name Cell contains right name");
        assertEquals(examinationWebsite.getFirstBugText(), "First Bug");
    }

    @Test
    public void test2() throws InterruptedException {
        logger.log("Click Add in form button");
        examinationWebsite.addFormButton().click();

        logger.log("Enter name into name field");
        examinationWebsite.nameFieldForm().sendKeys("Bug For Roman");

        logger.log("Enter note into text field");
        examinationWebsite.notesFieldForm().sendKeys("Some note");

        logger.log("Click OK button");
        examinationWebsite.okButton().click();

        logger.log("Check if my bug is present");
        Assert.assertTrue(examinationWebsite.myBugNameCell().isDisplayed());

        logger.log("Check if my bug contains right name");
        assertEquals(examinationWebsite.getMyBugName(), "Bug For Roman");

        logger.log("Click on my bug");
        examinationWebsite.myBugNameCell().click();

        logger.log("Click delete button");
        examinationWebsite.deleteButton().click();

        logger.log("Confirm deletion");
        examinationWebsite.confirmDeleteButton().click();

        logger.log("Check if my bug is not present");
        Thread.sleep(1000);
        try {
            browser.findElement(By.xpath("//div[contains(text(), 'Bug For Roman')]"));
            logger.log("Element Present");

        } catch (NoSuchElementException ex) {
            logger.log("Element absent");
        }
    }

    @Test
    public void test3() throws InterruptedException {

        logger.log("Click Add button and fill in data");
        Actions action = new Actions(browser);
        WebDriverWait wait = new WebDriverWait(browser, 5);
        examinationWebsite.addButton().click();
        Thread.sleep(1000);
        action.sendKeys("Bug For Roman").perform();
        Thread.sleep(1000);
        action.sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);
        action.sendKeys("Some note").perform();
        Thread.sleep(1000);
        action.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .perform();
        Thread.sleep(1000);

        logger.log("Click Apply button");
        examinationWebsite.applyButton().click();

        logger.log("Check if my bug is present");
        Assert.assertTrue(examinationWebsite.myBugNameCell().isDisplayed());

        logger.log("Click on my bug");
        Thread.sleep(1000);
        examinationWebsite.myBugNameCell().click();

        logger.log("Click delete button");
        examinationWebsite.deleteButton().click();

        logger.log("Confirm deletion");
        examinationWebsite.confirmDeleteButton().click();

        logger.log("Check if my bug is not present");
        Thread.sleep(1000);
        try {
            browser.findElement(By.xpath("//div[contains(text(), 'Bug For Roman')]"));
            logger.log("Element Present");

        } catch (NoSuchElementException ex) {
            logger.log("Element absent");
        }

    }

}
