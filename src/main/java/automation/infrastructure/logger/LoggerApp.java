package automation.infrastructure.logger;

public class LoggerApp {
    public static void main(String[] args) {

        TestLoggerOld logger = new TestLoggerOld();
        logger.log("Step 1");
        logger.log("Step 2");
        logger.log("Step 3");

        TestLogger filelogger = new FileTestLogger();
        filelogger.log("Step 1");
        filelogger.log("Step 2");
        filelogger.log("Step 3");

    }
}
