package org.example.utils.http;

public class HttpAttributes {
    String baseUri;
    String basePath;
    String content;

    public HttpAttributes(String baseUri, String basePath, String content) {
        this.baseUri = baseUri;
        this.basePath = basePath;
        this.content = content;
    }

    public HttpAttributes(String baseUri) {
        this(baseUri, "", "");
    }
}
