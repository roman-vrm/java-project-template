package projects.wp.tests;

import automation.infrastructure.base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookSearch extends TestBase {

    @Test
    public void SearchTest() throws InterruptedException {

        logger.log("Open website");
        browser.get("http://it-ebooks.info/");
        logger.log("Check website tittle");
        Assert.assertEquals(browser.getTitle(), "IT eBooks - Free Download - New Releases");
        logger.log("Enter search text");
        browser.findElement(By.id("q")).sendKeys("Functional Programming in Java");
        logger.log("Choose Search by title");
        browser.findElement(By.id("type")).click();
        logger.log("Click Search button");
        browser.findElement(By.xpath("//input[@type=\"submit\"]")).click();
        logger.log("Click book link");
        browser.findElement(By.xpath("//a[@title=\"Functional Programming in Java\"]")).click();
        logger.log("Compare book title with required");
        WebElement element = browser.findElement(By.xpath("//h1"));
        String result = element.getText();
        System.out.println(result);
        Assert.assertEquals("Functional Programming in Java", result);

    }
}
