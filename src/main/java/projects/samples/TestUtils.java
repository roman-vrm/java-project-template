package projects.samples;

import automation.infrastructure.utils.Utils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestUtils {


    @Test
    public  void randomRangeTest() {

        int random = Utils.randomFromRange(0, 15);

        assertTrue("Random number" + random, random >= 0);
        assertTrue("Random number" + random, random <= 15);

    }

}
