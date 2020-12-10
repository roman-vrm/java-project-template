package automation.infrastructure.webdrivermanager.capabilities;

import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserCapabilities {

    public static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        return options;
    }
}
