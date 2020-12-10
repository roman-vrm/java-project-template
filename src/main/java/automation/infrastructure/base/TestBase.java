package automation.infrastructure.base;

import automation.infrastructure.logger.TestLoggerOld;
import automation.infrastructure.utils.TestServer;
import automation.infrastructure.webdrivermanager.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class TestBase {

    private WebDriverManager wdm;
    protected WebDriver browser;
    protected TestLoggerOld logger;
    protected TestServer url;

    @Before
    public void setUp() {
        logger = new TestLoggerOld();
        wdm = new WebDriverManager();
        browser = wdm.getAvailableWebDriver();
        url = new TestServer();

        logger.log("Open website" + url);
//        browser.manage().window().setSize(new Dimension(1920, 1080));
        beforeTest();
    }

    @After
    public void cleanUp() {
        afterTest();

        logger.log("Close browser");
        wdm.destroy(browser);
    }

    protected void beforeTest() {}

    protected void afterTest() {}
}
