package automation.infrastructure.utils;

import java.util.HashMap;
import java.util.Map;

public class UrlBuilder {

    private String protocol = "";
    private String domain = "";
    private String port = "";
    private String path ="";
    private HashMap<String, String> params = new HashMap<>();

    public UrlBuilder() {
    }

    public UrlBuilder withProtocol (String protocol) {
        this.protocol = protocol;
        return this;
    }

    public UrlBuilder withDomain (String domain) {
        this.domain = domain;
        return this;
    }

    public UrlBuilder withPort (String port) {
        this.port = ":" + port;
        return this;
    }

    public UrlBuilder withPath (String path) {
        this.path = path;
        return this;
    }

    public UrlBuilder withParam (String param) {
        this.params.put(param, "");
        return this;
    }

    public UrlBuilder withParams (String key, String value) {
        this.params.put(key, value);
        return this;
    }

    public UrlBuilder withParams(HashMap<String, String> params) {
        this.params.putAll(params);
        return this;
    }

    public String build() {
        String q = "?";
        if (protocol == null || protocol.isEmpty())
            protocol = "http://";

        if (params == null || params.isEmpty())
            q = "";

        if (!path.startsWith("/"))
            path = "/" + path;

        String parameters = "";
        for (Map.Entry pair: params.entrySet()) {
            parameters += pair.toString() + "&";
        }

        return protocol + domain + port + path + q + parameters;
    }


}
