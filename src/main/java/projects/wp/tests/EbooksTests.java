package projects.wp.tests;

import automation.infrastructure.base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import projects.wp.drivers.EbooksWebsite;

import static org.junit.Assert.assertTrue;

public class EbooksTests extends TestBase{

    EbooksWebsite website;

    @Override
    protected void beforeTest() {
        website  = new EbooksWebsite(browser);

        logger.log("Open website");
        browser.get("http://it-ebooks.info/");
    }

    @Test
    public void searchJavaBook(){
        logger.log("Select search by title");
        website.searchPanel().titleRadio().click();

        logger.log("Enter search text");
        website.searchPanel().searchInput().sendKeys("Java");

        logger.log("Click on the search button");
        website.searchPanel().searchButton().click();

        logger.log("Click on the next page button");
        website.searchResultsPage().nextPageLink().click();

        logger.log("Click on the needed book");
        website.searchResultsPage().clickBook().click();

        logger.log("Verify that it's needed book and book page is opened");
        website.bookPage().checkResult();
    }

    @Test
    public void testTopDownloadedBook() {
        logger.log("Check block is present");
        assertTrue(website.mainPage().topDownloadedBooksBlock().isDisplayed());
        logger.log("Check block has 10 books");
        assertTrue(website.mainPage().topDownloadedBooksList().size() == 10);
    }

    @Test
    public void testLastUploadedBook() {
        logger.log("Check block is present");
        assertTrue(website.mainPage().lastUploadedBooksBlock().isDisplayed());
        logger.log("Check block has 10 books");
        assertTrue(website.mainPage().lastUploadedBooksList().size() == 20);
    }
}
