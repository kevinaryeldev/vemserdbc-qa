package br.com.dbcompany.aceitacao;

import br.com.dbcompany.dto.PetPayloadDTO;
import br.com.dbcompany.dto.ResponseDTO;
import br.com.dbcompany.service.PetService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PetAceitacaoTest {
    Integer baseId = 20220723;

    PetService service = new PetService();
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void testeDeveAdicionarPet() throws IOException {

        // Massa de dados
        String jsonBody = lerJson("src/test/resources/data/pet1.json");

        // Chamada para o serviço
        PetPayloadDTO resultService = service.adicionarPet(jsonBody);
        // validar os resultados obtidos
        Assert.assertEquals(resultService.getId(), ""+baseId);
        Assert.assertEquals(resultService.getName(), "Scooby");
        //assertThat;
        ResponseDTO resultService2 = service.deletarPet(baseId);
        Assert.assertEquals(resultService2.getCode(),"200");
    }

    @Test
    public void testeDeveconsultarPetPorID() throws IOException {
        String jsonBody = lerJson("src/test/resources/data/pet1.json");
        // Chamada para o serviço
        PetPayloadDTO resultServiceAdd = service.adicionarPet(jsonBody);
        // validar os resultados obtidos
        Assert.assertEquals(resultServiceAdd.getId(), ""+baseId);

        PetPayloadDTO resultService = service.consultarPetPorID(baseId);
        Assert.assertEquals(resultService.getId(), ""+baseId);
        Assert.assertEquals(resultService.getName(), "Scooby");
    }

    @Test
    public void testeDeveAtualizarPet() throws IOException {
        // Massa de dados1
        String jsonBody = lerJson("src/test/resources/data/pet1.json");

        // Chamada para o serviço
        PetPayloadDTO resultServiceAdd = service.adicionarPet(jsonBody);
        // validar os resultados obtidos
        Assert.assertEquals(resultServiceAdd.getId(), ""+baseId);
        Assert.assertEquals(resultServiceAdd.getName(), "Scooby");

        // Massa de dados 2
        String jsonBody2 = lerJson("src/test/resources/data/pet2.json");
        // Chamada para o serviço
        PetPayloadDTO resultServiceAtt = service.atualizarPet(jsonBody2);

        // validar os resultados obtidos
        Assert.assertEquals(resultServiceAtt.getName(), "Doo");

    }

    @Test
    public void testDeveDeletarPet() {
        ResponseDTO responseService = service.deletarPet(baseId);

        Assert.assertEquals(responseService.getCode(), "200");
        Assert.assertEquals(responseService.getMessage(), ""+baseId);



    }

}