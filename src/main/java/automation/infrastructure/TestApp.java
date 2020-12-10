package automation.infrastructure;

import automation.infrastructure.config.ConfigurationManager;
import automation.infrastructure.utils.StringUtils;
import automation.infrastructure.utils.TestServer;
import automation.infrastructure.logger.TestLoggerOld;
import automation.infrastructure.utils.Utils;
import automation.infrastructure.webdrivermanager.WebDriverManager;

public class TestApp {
         public static void main(String[] args) {
             TestLoggerOld old_logger = new TestLoggerOld();
             TestServer urlForLog = new TestServer();
             WebDriverManager browserForLog = new WebDriverManager();
             StringUtils alphanumeric = new StringUtils();

             old_logger.log(urlForLog.getAdress());


             String browser = ConfigurationManager.getInstance().getTestBrowser();
             String url = ConfigurationManager.getInstance().getUrl();
             String factory = ConfigurationManager.getInstance().getRunOn();


             System.out.println(browser);
             System.out.println(url);
             System.out.println(factory);
        }
    }
