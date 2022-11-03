package br.com.dbcompany.service;

import br.com.dbcompany.dto.PetPayloadDTO;
import br.com.dbcompany.dto.ResponseDTO;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class PetService {
    String baseUri = "https://petstore.swagger.io/v2";
    Integer baseId = 20220723;


    public PetPayloadDTO adicionarPet(String requetBody) {
        PetPayloadDTO result =
            given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(requetBody)
            .when()
                .post(baseUri + "/pet") // uri + endpoint mostrado na api
            .then()
                .log().all()
                .extract().as(PetPayloadDTO.class);

        return result;
    }

    public PetPayloadDTO consultarPetPorID(Integer idPet) {
        PetPayloadDTO result = given()
            .log().all()
            .contentType(ContentType.JSON)
            .pathParam("idPet",idPet)
        .when()
            .get(baseUri + "/pet/{idPet}")
        .then()
            .log().all()
            .extract().as(PetPayloadDTO.class);
        return result;
    }

    public PetPayloadDTO atualizarPet(String jsonBody) {
        PetPayloadDTO result = given()
                .log().all()
                .contentType(ContentType.JSON)
                .when()
                .put(baseUri+"/pet")
                .then()
                .log().all()
                .extract().as(PetPayloadDTO.class);
        return result;
    }

    public ResponseDTO deletarPet(Integer idPet) {
        ResponseDTO result = given()
                .log().all()
                .contentType(ContentType.JSON)
                .pathParam("idPet",idPet)
                .when()
                .delete(baseUri +"/pet/{idPet}")
                .then()
                .log().all()
                .extract().as(ResponseDTO.class);
        return result;
    }
}
