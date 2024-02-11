package org.example.utils.rest.client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.utils.config.ProjectProperties;

import java.io.IOException;

public class HttpCatsClient extends BaseClient {
    private RequestSpecification setRequest() throws IOException {
        new ProjectProperties("httpcat");
        return RestAssured
                .given()
                .accept("application/json")
                .contentType(ContentType.JSON)
                .baseUri(ProjectProperties.url);
    }

    public Response getCat(String status) throws IOException {
        return setRequest()
                .when()
                .get(String.format("%s", status));
    }
}
