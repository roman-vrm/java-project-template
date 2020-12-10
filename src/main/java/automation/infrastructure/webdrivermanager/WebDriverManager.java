package automation.infrastructure.webdrivermanager;

import automation.infrastructure.config.ConfigurationManager;
import automation.infrastructure.webdrivermanager.factory.BuildServerWebDriverManager;
import automation.infrastructure.webdrivermanager.factory.CloudWebDriverFactory;
import automation.infrastructure.webdrivermanager.factory.LocalWebDriverFactory;
import automation.infrastructure.webdrivermanager.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class WebDriverManager {


    public WebDriver getAvailableWebDriver(){

        EnvironmentType runOn = EnvironmentType.valueOf(ConfigurationManager.getInstance().getRunOn());

        WebDriverFactory factory;

        switch (runOn) {
            case LOCAL:
                factory = new LocalWebDriverFactory();
                break;
            case BUILDSERVER:
                factory = new BuildServerWebDriverManager();
                break;
            case CLOUD:
                factory = new CloudWebDriverFactory();
                break;
            default:
                throw new RuntimeException("No such env");
        }

        return factory.create();
    }


    public void destroy (WebDriver browser) {
        if (browser != null) {
            browser.quit();
        }
        System.out.println(browser + "was closed");
    }
}
