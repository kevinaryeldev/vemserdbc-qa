package br.com.dbccompany.service;

import br.com.dbccompany.dto.ResponseDTO;
import br.com.dbccompany.dto.UserPayloadDTO;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UserService {
    static Integer SC_OK = 200;
    static String baseUri ="https://petstore.swagger.io/v2/user";
    public static ResponseDTO adicionarUser(String requestBody){
        ResponseDTO result =
            given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(requestBody)
            .when()
                .post(baseUri)
            .then()
                    .log().all()
                    .extract().as(ResponseDTO.class);
        return result;
    }

    public static UserPayloadDTO consultarUserPassandoUsername(String username){
        UserPayloadDTO result =
            given()
                .contentType(ContentType.JSON)
                .pathParam("userName",username)
            .when()
                .get(baseUri+"/{userName}")
            .then()
                .extract().as(UserPayloadDTO.class);
        return result;
    }
    public static ResponseDTO deletarUsuarioPassandoUsername(String username){
        ResponseDTO result =
            given()
                .contentType(ContentType.JSON)
                .pathParam("username",username)
            .when()
                .delete(baseUri+"/{username}")
            .then()
                .extract().as(ResponseDTO.class);
        return result;
    }

    public static void falhaDeletarUsuarioPassandoUsernameErrado(String username){
                        given()
                        .contentType(ContentType.JSON)
                        .pathParam("username",username)
                        .when()
                        .delete(baseUri+"/{username}")
                        .then()
                        .statusCode(404);
        return;
    }

    public static void falhaDeletarUsuarioSemPassarUsername(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .delete(baseUri)
                .then()
                .statusCode(405);
        return;
    }

    public static ResponseDTO atualizarUsuarioPassandoUsername(String username,String requestBody){
        ResponseDTO result =
            given()
                .contentType(ContentType.JSON)
                .pathParam("username",username)
                .body(requestBody)
            .when()
                .put(baseUri+"/{username}")
            .then()
                .statusCode(SC_OK)
                .extract().as(ResponseDTO.class);
        return result;
    }

}
