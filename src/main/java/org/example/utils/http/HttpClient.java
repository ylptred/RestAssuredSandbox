package org.example.utils.http;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class HttpClient {
    HttpAttributes attributes;

    public HttpClient(HttpAttributes attributes) {
        this.attributes = attributes;
    }

    public Response getRequest() {
        Response response = RestAssured
                .given()
                .accept(ContentType.HTML)
                .log()
                .all()
                .baseUri(attributes.baseUri)
                .basePath(attributes.basePath)
                .when()
                .get();
        return response;
    }

    public Response postRequest() {
        Response response = RestAssured
                .given()
                .baseUri(attributes.baseUri)
                .basePath(attributes.basePath)
                .body(attributes.content)
                .when()
                .post();
        return response;
    }

    public Response putRequest() {
        Response response = RestAssured
                .given()
                .baseUri(attributes.baseUri)
                .basePath(attributes.basePath)
                .body(attributes.content)
                .when()
                .put();
        return response;
    }
}