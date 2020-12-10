package automation.infrastructure.utils;

public class MyUrl {

    private String secure;
    private String domain;
    private String port;
    private String path;
    private String parameter;

    public MyUrl(Builder builder) {
        this.secure = builder.secure;
        this.domain = builder.domain;
        this.port = builder.port;
        this.path = builder.path;
        this.parameter = builder.parameter;
    }

    @Override
    public String toString() {
        return secure + domain + port + path + "?" + parameter;
    }

    public static class Builder {

        private String secure = "";
        private String domain = "";
        private String port = "";
        private String path = "";
        private String parameter = "";

        public Builder secure (String secure) {
            this.secure = secure + "://";
            return this;
        }

        public Builder domain (String domain) {
            this.domain = domain;
            return this;
        }

        public Builder port (String port) {
            this.port = ":" + port;
            return this;
        }

        public Builder path (String path) {
            this.path = "/" +  path;
            return this;
        }

        public Builder parameter (String key, String value) {
            this.parameter += key + "=" + value;
            return this;
        }

        public MyUrl build() {
            if (this.secure == null || this.secure.isEmpty())
                secure = "http://";
            return new MyUrl(this);
        }
    }

    public static void main(String[] args) {
        MyUrl address = new Builder().secure("https").domain("www.google.com").port("80").path("some_path").parameter("some_key", "some_value").build();
        System.out.println(address.toString());
    }
}
