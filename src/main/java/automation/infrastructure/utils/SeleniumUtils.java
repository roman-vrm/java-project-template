package automation.infrastructure.utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class SeleniumUtils {

    private static String initialWindowHandle = "";

    public static void swithToWindow (WebDriver webDriver, String windowTitle) {

       initialWindowHandle = webDriver.getWindowHandle();
        Set<String> windows = webDriver.getWindowHandles();

        if (windows.size() < 2)
            throw new RuntimeException("New window was not open");
        for (String wnd: windows) {
            webDriver.switchTo().window(wnd);

            if (webDriver.getTitle().equals(windowTitle))
                break;
        }
    }

    public static void switchToInitialWindow (WebDriver webDriver) {
        if (!initialWindowHandle.isEmpty())
            webDriver.switchTo().window(initialWindowHandle);

    }
}
