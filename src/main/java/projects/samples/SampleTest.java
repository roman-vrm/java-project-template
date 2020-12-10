package projects.samples;

import automation.infrastructure.base.TestBase;
import org.junit.Test;

public class SampleTest extends TestBase {

    @Test
    public void test() {
        logger.log("step1");
        logger.log("step2");
        logger.log("step3");
    }
}
