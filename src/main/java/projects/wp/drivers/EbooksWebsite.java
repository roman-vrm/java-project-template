package projects.wp.drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import projects.wp.drivers.components.SearchPanel;

public class EbooksWebsite {
    private WebDriver webDriver;

    public EbooksWebsite(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public MainPage mainPage(){
        return new MainPage(webDriver);
    }

    public SearchResultsPage searchResultsPage(){
        return new SearchResultsPage(webDriver);
    }

    public BookPage bookPage() {
        return new BookPage(webDriver);
    }

    public SearchPanel searchPanel() {
        return new SearchPanel(webDriver.findElement(By.id("searchform")));
    }
}
