package projects.wp.drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    public SearchResultsPage(WebDriver driver){
        this.webDriver = driver;

        PageFactory.initElements(webDriver, this);
    }


    //  Methods
    public WebElement nextPageLink() {
        try{
            return  webDriver.findElement(By.cssSelector("a[title='Next page"));
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public WebElement clickBook() {
        try{
            List<WebElement> links = webDriver.findElements(By.cssSelector("a[title='Functional Programming in Java']"));
            return  links.get(1);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
