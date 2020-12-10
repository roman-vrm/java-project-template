package projects.wp.drivers.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPanel {

    private WebElement element;

    public SearchPanel(WebElement element) {
        this.element = element;


    }

    //    Elements

    @FindBy(css = "input[value='title']")
    WebElement titleRadioBTN;

    @FindBy(id = "q")
    WebElement searchField;

    @FindBy(css = "input[type='submit']")
    WebElement searchBTN;

    //    Methods

    public WebElement titleRadio() {
        try{
            return element.findElement(By.cssSelector("input[value='title']"));
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public WebElement searchInput() {
        try{
            return element.findElement(By.id("q"));
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public WebElement searchButton() {
        try{
            return element.findElement(By.cssSelector("input[type='submit']"));
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
