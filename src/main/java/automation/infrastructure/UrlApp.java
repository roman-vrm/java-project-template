package automation.infrastructure;

import automation.infrastructure.utils.UrlBuilder;

public class UrlApp {
    public static void main(String args[]) {
        String url = new UrlBuilder()
                .withDomain("test.mysite.com")
                .withPath("path/to/controller")
                .withPort("3000")
                .withParams("debug", "true")
                .withParams("exp1", "true")
                .withParams("exp2", "false")
                .withParam("staging")
                .build();

        System.out.println(url);

//        HashMap<String, String> map = new HashMap<>();
//        map.put("a", "1");
//        map.put("b", "2");
//        map.put("c", "3");
//        map.put("d", "4");
//        map.put("e", "5");
//
//        System.out.println(map.entrySet());
    }
}
