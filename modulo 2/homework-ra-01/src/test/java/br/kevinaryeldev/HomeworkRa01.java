package br.kevinaryeldev;

import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;

public class HomeworkRa01 {
    String baseUrl = "https://reqres.in/api";

    @Test
    public void testeListUsers(){
        given()
                .queryParam("page","2")
        .when()
            .get(baseUrl+"/users")
        .then()
            .statusCode(200)
            .body("data",hasSize(6))
            .body("data[0].id",equalTo(7))
            .body("data[5].id",equalTo(12))
            .body("data.first_name",hasItem("George"));
    }

    @Test
    public void testeGetSingleUser(){
        given()
                .when()
                    .get(baseUrl+"/users/2")
                .then()
                    .statusCode(200)
                    .body("data.id", is(2))
                    .body("data.first_name",equalTo("Janet"));
    }

    @Test
    public void testeUsuarioNaoEncontrado(){
        given()
        .when()
            .get(baseUrl+"/users/50")
        .then()
                .statusCode((404));
    }
    @Test
    public void testarListaDeRecursos(){
        given()
        .when()
            .get(baseUrl+"/unknown")
        .then()
            .statusCode(200)
            .body("page",is(1))
            .body("data",hasSize(6))
            .body("data.year",hasItem(2001))
            .body("data[0].name",equalTo("cerulean"));
    }
    @Test
    public void testarItemRecurso(){
        given()
        .when()
            .get(baseUrl+"/unknown/3")
        .then()
            .statusCode(200)
        .body("data.id",is(3))
        .body("data.name",endsWith("red"))
        .body("data.year",equalTo(2002));
    }

    @Test
    public void testarRecursoNaoEncontrado(){
        given()
        .when()
        .get(baseUrl+"/unknown/56")
        .then()
                .statusCode(404);
    }
    @Test
    public void testarCreate(){
        given()
            .contentType(ContentType.JSON)
            .body("{\"name\" : \"Kevin Aryel\", \"job\" : \"QA\" }")
        .when()
            .post(baseUrl+"/users")
        .then()
            .log().all()
            .statusCode(201)
            .body("name",startsWith("Kevin"))
            .body("job", is("QA"))
            .body("id",not(nullValue()))
            .body(containsString("createdAt"));
    }
    @Test
    public void testarUpdate(){
        given()
                .contentType(ContentType.JSON)
                .body("{ \"name\" : \"Kevin Silva\", \"job\" : \"QA Jr\"  }")
        .when()
            .put(baseUrl+"/users/4")
        .then()
            .statusCode(200)
            .body("name",is("Kevin Silva"))
            .body(containsString("updatedAt"))
            .body("job", is("QA Jr"));
    }
    @Test
    public void testarUpdate2(){
        given()
            .contentType(ContentType.JSON)
            .body("{\"job\" : \"QA Jr\" }")
        .when()
            .patch(baseUrl+"/users/2")
        .then()
            .body("job", containsString("QA"))
            .log().all()
            .statusCode(200)
            .body(containsString("updatedAt"));
    };

    @Test
    public void testarDelete(){
        given()
        .when()
            .delete(baseUrl+"/users/2")
        .then()
            .statusCode(204);
    }
    @Test
    public void testarRegistroComSucesso(){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("password", "1QA243");
        params.put("email", "lindsay.ferguson@reqres.in");
        given()
            .contentType(ContentType.JSON)
            .body(params)
        .when()
            .post(baseUrl+"/register")
        .then()
            .statusCode(200)
            .body("id", not(nullValue()))
            .body(containsString("token"));
    }
    @Test
    public void testarRegistroSemSenha(){
        given()
            .contentType(ContentType.JSON)
            .body("{ \"email\": \"sydney@fife\" }")
        .when()
            .post(baseUrl+"/register")
        .then()
            .statusCode(400)
            .body(containsString("error"))
            .body("error",is("Missing password"));
    }
    @Test
    public void testarRegistroSemUser(){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("password", "1QA243");
        params.put("email", "teste.darerrado@reqres.in");
        given()
            .contentType(ContentType.JSON)
            .body(params)
        .when()
            .post(baseUrl+"/register")
        .then()
            .statusCode(400)
            .body(containsString("error"))
            .body("error",containsString("Only defined users"));
    }
    @Test
    public void testarLoginComSucesso(){
        given()
            .contentType(ContentType.JSON)
            .body("{ \"email\": \"eve.holt@reqres.in\" , \"password\": \"cityslicka\"} ")
        .when()
            .post(baseUrl+"/login")
        .then()
            .statusCode(200)
            .body(containsString("token"));
    }
    @Test
    public void testarLoginSemSenha(){
        given()
            .contentType(ContentType.JSON)
            .body("{ \"email\": \"eve.holt@reqres.in\"} ")
        .when()
            .post(baseUrl+"/login")
        .then()
            .statusCode(400)
            .body(containsString("error"))
            .body("error",is("Missing password"));
    }
    @Test
    public void testarLoginVazio(){
        given()
            .contentType(ContentType.JSON)
        .when()
            .post(baseUrl+"/login")
        .then()
            .statusCode(400)
        .body("error",is("Missing email or username"));
    }
    @Test
    public void testarLoginComUserErrado(){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("password", "1QA243");
        params.put("email", "teste.darerrado@reqres.in");
        given()
            .contentType(ContentType.JSON)
            .body(params)
        .when()
            .post(baseUrl+"/login")
        .then()
            .statusCode(400)
            .body("error",is("user not found"));
    }
}
