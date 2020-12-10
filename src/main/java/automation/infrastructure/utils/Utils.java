package automation.infrastructure.utils;

public class Utils {
    public static int randomFromRange(int min, int max) {

        return min+ (int) (Math.random()*((max-min)+1));
    }
}
