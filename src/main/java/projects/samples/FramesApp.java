package projects.samples;

import automation.infrastructure.base.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;

public class FramesApp extends TestBase{

    @Test
    public void FrameTest() {

        browser.get("http://website.com");
        browser.switchTo().frame((browser.findElement(By.id("id"))));
        browser.close();
    }
}
