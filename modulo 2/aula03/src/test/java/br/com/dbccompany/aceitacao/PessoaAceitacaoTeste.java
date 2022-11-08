package br.com.dbccompany.aceitacao;

import br.com.dbccompany.DTO.RelatorioDTO;
import br.com.dbccompany.service.PessoaService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PessoaAceitacaoTeste {

    PessoaService service = new PessoaService();

    @Test
    public void deveRetornarRelatorioPessoa(){
        RelatorioDTO[] resultService = service.buscaRelatorio();
        //Assert.assertEquals(resultService[0].,);
    }


}
