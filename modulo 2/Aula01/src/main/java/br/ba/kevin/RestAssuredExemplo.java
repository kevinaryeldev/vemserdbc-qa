package br.ba.kevin;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredExemplo {
    private String baseUrl = "https://regress.in/api";

    @Test
    public void testPut(){
        given()
            .log().all()
            .contentType(ContentType.JSON)
            .body("{\"name\" :\"Carlos\" , \"job\":\"QA\" }")
        .when()
            .post(baseUrl + "/users")
        .then()
            .log().all()
            .statusCode(201)
            .body("name",is("Kevin"));
    }

}
