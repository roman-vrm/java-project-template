package automation.infrastructure.utils;

import automation.infrastructure.config.ConfigurationManager;

public class TestServer {

    public String getAdress(){
        String server = ConfigurationManager.getInstance().getUrl();
        switch (server){
            case "Local":
                return "htp://192.168.0.15";
            case "Staging":
                return "http://staging.website.com";
            case "Production":
                return "http://website.com";
            default:
                return "http://google.com";
        }
    }
}
