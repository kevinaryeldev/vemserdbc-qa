import Contrato from "../../service/apiPessoa.service"

context('Contrato Pessoa',()=>{
    it('Contrato - validar o contrato pessoa - lista com endereco',()=>{
        Contrato.contratoRequest('pessoa.listaendereco.json','pessoa/lista-com-enderecos')
    })

    it('Contrato - validar o contrato pessoa- pegar relatorio',()=>{
        Contrato.contratoRequest('pessoa.pegarrelatorio.json','pessoa/relatorio?idPessoa=4')
    })

    it('Contrato - validar o contrato pessoa - lista completa',()=>{
        Contrato.contratoRequest('pessoa.listacompleta.json','pessoa/lista-completa')
    })
    it('Contrato - validar o contrato pessoa - por nome',()=>{
        Contrato.contratoRequest('pessoa.array.json','pessoa/byname?nome=Kevin')
    })
    it('Contrato - validar o contrato pessoa - por cpf',()=>{
        Contrato.contratoRequest('pessoa.simplificado.json','pessoa/999999999/cpf')
    })
    it('Contrato - validar o contrato pessoa - lista simplificada',()=>{
        Contrato.contratoRequest('pessoa.listasimplificada.json','pessoa/')
    })
    it('Contrato - validar o contrato pessoa - lista contatos',()=>{
        Contrato.contratoRequest('pessoa.listacontatos.json','pessoa/lista-com-contatos')
    })
})
