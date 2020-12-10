package automation.infrastructure.webdrivermanager.factory;

import automation.infrastructure.config.ConfigurationManager;
import automation.infrastructure.webdrivermanager.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CloudWebDriverFactory implements WebDriverFactory {

    @Override
    public WebDriver create() {

        BrowserType testBrowser = BrowserType.valueOf(ConfigurationManager.getInstance().getTestBrowser());

        switch (testBrowser) {
            case CHROME:
                return new ChromeDriver();
            case  FIREFOX:
                return new FirefoxDriver();
            case  SAFARI:
                return null;
            case  IE:
                return null;
            default:
                throw new RuntimeException("This browser is not supported");
        }
    }
}
