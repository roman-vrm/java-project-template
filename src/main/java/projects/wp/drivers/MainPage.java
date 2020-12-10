package projects.wp.drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import projects.wp.drivers.models.Book;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private WebDriver webDriver;
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.webDriver = driver;

        PageFactory.initElements(webDriver, this);
    }

    public List<WebElement> topDownloadedBooksList() {
        try{
            return topDownloadedBooksBlock().findElements(By.cssSelector("top_box"));
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public List<WebElement> lastUploadedBooksList() {
        try{
            return lastUploadedBooksBlock().findElements(By.cssSelector("td[width='370']"));
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public WebElement topDownloadedBooksBlock() {
        try{
            return booksBlock("Top Download eBooks");
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public WebElement lastUploadedBooksBlock() {
        try{
            return booksBlock("Last Upload eBooks");
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public WebElement booksBlock (String title) {
        try{
            List<WebElement> blocks = webDriver.findElements(By.className("top"));

            WebElement bl = null;

            for (WebElement block: blocks) {
                if (block.getText().contains(title))
                    bl = block;
            }
            if (bl == null)
                throw new Exception("Web element as not found");
            return bl;
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
