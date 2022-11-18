import Contrato from "../../service/apiPessoa.service"

context('Contrato Endereco',()=>{
    it('Contrato - validar o contrato endereco - lista com endereco',()=>{
        Contrato.contratoRequest('endereco.listapaginada.json','endereco/')
    })
    it('Contrato - validar o contrato endereco - lista por pais',()=>{
        Contrato.contratoRequest('endereco.listaitens.json','endereco/retorna-por-pais?Pa%C3%ADs=Brasil')
    })
    it('Contrato - validar o contrato endereco - lista por pessoa',()=>{
        Contrato.contratoRequest('endereco.listaitens.json','retorna-por-id-pessoa?idPessoa=5333')
    })
    it('Contrato - validar o contrato endereco - lista por id Endereco',()=>{
        Contrato.contratoRequest('endereco.listaitens.json','endereco/1')
    })
})
