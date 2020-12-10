package projects.samples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class WebElementsApp {

    public static void main(String[] args) {

        WebDriver webDriver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebDriverWait wait = new WebDriverWait(webDriver,60,1000);

        webDriver.get("http://thebestwebsite.22web.org/wordpress/admin");
        System.out.println(webDriver.findElement(By.className("main-navigation")).getText());
        List<WebElement> articles = webDriver.findElement(By.id("main")).findElements(By.tagName("article"));
        assertTrue(articles.size() == 2);

        WebElement textArticle;

        for (WebElement article: articles) {
            if (article.getAttribute("class").contains("video-post")) {
               article.findElement(By.className("entry-title")).findElement(By.tagName("a")).click();
               break;
            }
        }

        assertTrue(webDriver.getCurrentUrl().contains("2017/12/21"));

        webDriver.findElement(By.id("user_login")).sendKeys("admin");


        webDriver.quit();
    }
}
