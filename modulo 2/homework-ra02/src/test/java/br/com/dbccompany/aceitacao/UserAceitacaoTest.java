package br.com.dbccompany.aceitacao;

import br.com.dbccompany.dto.ResponseDTO;
import br.com.dbccompany.dto.UserPayloadDTO;
import br.com.dbccompany.service.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class UserAceitacaoTest {
    Integer idUser = 23;
    String username = "KevinQA";
    Integer SC_OK = 200;
    public String lerJson(String caminhoJson) throws IOException{
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void testarAdicionarDeletarUsuruarioComSucesso1() throws IOException {
        //Adicionando User
        String jsonBody = lerJson("src/test/resources/data/user1.json");
        ResponseDTO resultBody = UserService.adicionarUser(jsonBody);
        Assert.assertEquals(SC_OK,resultBody.getCode());
        //Deletando User
        ResponseDTO resultBodyDelete = UserService.deletarUsuarioPassandoUsername(username);
        Assert.assertEquals(SC_OK,resultBodyDelete.getCode());
    }
    @Test
    public void testarAdicionarDeletarUsuarioComSucesso2() throws IOException{
        String jsonBody = lerJson("src/test/resources/data/user2.json");
        ResponseDTO resultBody = UserService.adicionarUser(jsonBody);
        Assert.assertEquals(SC_OK,resultBody.getCode());
        //Deletando User
        ResponseDTO resultBodyDelete = UserService.deletarUsuarioPassandoUsername(username);
        Assert.assertEquals(SC_OK,resultBodyDelete.getCode());
    }

    @Test
    public void testarFalhaAdicionarUsuarioSemDados() {
        ResponseDTO resultBody = UserService.adicionarUser("{}");
        Assert.assertEquals(SC_OK,resultBody.getCode());
    }
    @Test
    public void testarFalhaAdicionarUsuarioSemBody(){
        Integer SC_INVALID = 405;
        ResponseDTO resultBody = UserService.adicionarUser("");
        Assert.assertEquals(resultBody.getCode(),SC_INVALID);
    }

    @Test
    public void testarPegarUsuarioComUsername() throws IOException{
        //Adicionando usuario na db
        String jsonBodyPost = lerJson("src/test/resources/data/user1.json");
        ResponseDTO resultBodyPost = UserService.adicionarUser(jsonBodyPost);
        Assert.assertEquals(SC_OK,resultBodyPost.getCode());

        //Pegando dados do usuario
        UserPayloadDTO resultBodyGet = UserService.consultarUserPassandoUsername(username);
        Assert.assertEquals(resultBodyGet.getUsername(),username);
        Assert.assertEquals(resultBodyGet.getId(),idUser);
    }
    @Test
    public void testarPegarUsuarioComUsername2() throws IOException{
        String jsonBodyPost = lerJson("src/test/resources/data/user2.json");
        ResponseDTO resultBodyPost = UserService.adicionarUser(jsonBodyPost);
        Assert.assertEquals(SC_OK,resultBodyPost.getCode());

        UserPayloadDTO resultBodyGet = UserService.consultarUserPassandoUsername(username);
        Assert.assertEquals(resultBodyGet.getUsername(),username);
        Assert.assertEquals(resultBodyGet.getId(),idUser);
    }

    @Test
    public void testarFalhaPegarUsuarioComUsernameNaoEncontrado() throws IOException{
        UserPayloadDTO resultBodyGet = UserService.consultarUserPassandoUsername("ahahah");
        Assert.assertEquals(resultBodyGet.getUsername(),null);
    }

    @Test
    public void testarFalhaPegarUsuarioSemUsername() throws IOException{
        UserPayloadDTO resultBodyGet = UserService.consultarUserPassandoUsername(" ");
        Assert.assertEquals(resultBodyGet.getUsername(),null);
    }

    @Test
    public void testarDeletarUsuarioPassandoUsername() throws IOException {
        //Adicionando usuario na db
        String jsonBodyPost = lerJson("src/test/resources/data/user1.json");
        ResponseDTO resultBodyPost = UserService.adicionarUser(jsonBodyPost);
        Assert.assertEquals(SC_OK,resultBodyPost.getCode());
        //testar deletar usuario
        ResponseDTO resultBodyDelete = UserService.deletarUsuarioPassandoUsername(username);
        Assert.assertEquals(SC_OK,resultBodyDelete.getCode());
    }
    @Test
    public void testarDeletarUsuarioPassandoUsername2() throws IOException {
        String jsonBodyPost = lerJson("src/test/resources/data/user2.json");
        ResponseDTO resultBodyPost = UserService.adicionarUser(jsonBodyPost);
        Assert.assertEquals(SC_OK,resultBodyPost.getCode());
        //testar deletar usuario
        ResponseDTO resultBodyDelete = UserService.deletarUsuarioPassandoUsername(username);
        Assert.assertEquals(SC_OK,resultBodyDelete.getCode());
    }

    @Test
    public void testarDeletarUsuarioComUsernameErrado() throws IOException {
        String jsonBodyPost = lerJson("src/test/resources/data/user1.json");
        ResponseDTO resultBodyPost = UserService.adicionarUser(jsonBodyPost);
        Assert.assertEquals(SC_OK,resultBodyPost.getCode());
        UserService.falhaDeletarUsuarioPassandoUsernameErrado("AAAAA");
    }

    @Test
    public void testarDeletarUsuarioSemUsername(){
        UserService.falhaDeletarUsuarioSemPassarUsername();
    }

    //O put sempre retorna 200, já não sei o que usar
    @Test
    public void testarAtualizarUsuarioPassandoUsername() throws IOException {
        //Adicionando usuario na db
        String jsonBodyPost = lerJson("src/test/resources/data/user1.json");
        ResponseDTO resultBodyPost = UserService.adicionarUser(jsonBodyPost);
        Assert.assertEquals(SC_OK,resultBodyPost.getCode());
        //Testar atualizar usuario
        String jsonBodyPut = lerJson("src/test/resources/data/user2.json");
        ResponseDTO resultBodyPut = UserService.atualizarUsuarioPassandoUsername(username,jsonBodyPut);
        Assert.assertEquals(resultBodyPut.getCode(),SC_OK);

    }

}
