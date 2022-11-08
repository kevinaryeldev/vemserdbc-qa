package br.com.dbccompany.service;

import br.com.dbccompany.DTO.RelatorioDTO;
import br.com.dbccompany.utils.Login;

import static io.restassured.RestAssured.given;

public class PessoaService {
    String baseUri = "http://vemser-dbc.dbccompany.com.br:39000/vemser/dbc-pessoa-api";
    // String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiMiIsImNhcmdvcyI6WyJST0xFX01BUktFVElORyIsIlJPTEVfVVNVQVJJTyIsIlJPTEVfQURNSU4iXSwiaWF0IjoxNjY3NDk3OTI2LCJleHAiOjE2Njc1ODQzMjZ9.oqEzAMPssfwfKKEiU4KQQNhwgFNYzIEJaKsqwT7pjlY";
    String tokenAdmin = new Login().autenticacaoAdmin();
    public RelatorioDTO[] buscaRelatorio(){
        RelatorioDTO[] result =
            given().header("Authorization", tokenAdmin)
            .when()
                .get(baseUri+"/pessoa/relatorio")
            .then()
                .log().all()
                .statusCode(200)
                .extract().as(RelatorioDTO[].class);
        return result;
    }
}
