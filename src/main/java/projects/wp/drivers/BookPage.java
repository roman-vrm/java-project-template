package projects.wp.drivers;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BookPage {

    private WebDriver webDriver;

    public BookPage(WebDriver webDriver) {
        this.webDriver = webDriver;

        PageFactory.initElements(webDriver, this);
    }

    public void checkResult() {
        try{
            WebElement element = webDriver.findElement(By.xpath("//h1"));
            String result = element.getText();
            System.out.println(result);
            Assert.assertEquals("Functional Programming in Java", result);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
