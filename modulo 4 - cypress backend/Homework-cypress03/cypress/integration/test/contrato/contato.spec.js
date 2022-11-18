import Contrato from "../../service/apiPessoa.service"
context('Contrato Contato',()=>{
    it('Contrato - validar o contrato contato - lista com endereco',()=>{
        Contrato.contratoRequest('contato.listaitens.json','contato/')
    })
    it('Contrato - validar o contrato contato - lista por pessoa',()=>{
        Contrato.contratoRequest('contato.listaitens.json','contato/5333')
    })
})
