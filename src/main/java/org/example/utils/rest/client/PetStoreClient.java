package org.example.utils.rest.client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.utils.config.ProjectProperties;

import java.io.IOException;

public class PetStoreClient extends BaseClient {

    private RequestSpecification setRequest() throws IOException {
        new ProjectProperties("petstore");
        return RestAssured
                .given()
                .accept("application/json")
                .contentType(ContentType.JSON)
                .baseUri(ProjectProperties.url);
    }
    public ValidatableResponse addPet(String content) throws IOException {
        return setRequest()
                .body(content)
                .when()
                .post("/pet")
                .then()
                .statusCode(200);
    }
}
