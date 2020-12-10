package projects.samples;

import automation.infrastructure.utils.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StringUtilsTest {
    @Test
    public  void testRandomString() {

        String str = StringUtils.randomString("numeric", 10);

        assertEquals(str.length(), 10);
        assertTrue("Random string" + str, str.matches("\\d+"));

    }
}
