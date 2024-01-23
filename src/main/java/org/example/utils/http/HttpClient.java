package org.example.utils.http;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.when;

public class HttpClient {
    HttpAttributes attributes;

    public HttpClient(HttpAttributes attributes) {
        this.attributes = attributes;
    }

    static {
        RestAssured.filters(new RequestLoggingFilter(LogDetail.ALL), new ResponseLoggingFilter(LogDetail.ALL));
    }

    private RequestSpecification setRequest() {
        RequestSpecification request = RestAssured
                .given()
                .accept(ContentType.BINARY)
                .baseUri(attributes.baseUri);
        return request;
    }

    public Response getRequest() {
        Response response = setRequest()
                .when()
                .get(attributes.basePath);
        return response;
    }

    public Response postRequest() {
        Response response = setRequest()
                .body(attributes.content)
                .when()
                .post(attributes.basePath);
        return response;
    }

    public Response putRequest() {
        Response response = setRequest()
                .body(attributes.content)
                .when()
                .put(attributes.basePath);
        return response;
    }
}