import Contrato from "../../service/apiPessoa.service"

let patchFixture = 'contrato-pessoa/'

context('Contrato Pessoa',()=>{
    beforeEach(()=>{
        cy.criarDados()
    })

    afterEach(()=>{
        cy.deletarDados()
    })
    it('Contrato - validar o contrato pessoa - lista com endereco',()=>{
        cy.allure()
        .epic('Teste de Contrato')
        .feature('Pessoa')
        .story('Validar lista de Pessoa com endereço');
        Contrato.contratoRequest(`${patchFixture}pessoa.listaendereco.json`,'pessoa/lista-com-enderecos')
    })
    it('Contrato - validar o contrato pessoa- pegar relatorio',()=>{
        cy.allure()
        .epic('Teste de Contrato')
        .feature('Pessoa')
        .story('Validar lista de Pessoa - relatório');
        Contrato.contratoRequest(`${patchFixture}pessoa.pegarrelatorio.json`,`pessoa/relatorio?idPessoa=${Cypress.config('idPessoa')}`)
    })
    it('Contrato - validar o contrato pessoa - lista completa',()=>{
        cy.allure()
        .epic('Teste de Contrato')
        .feature('Pessoa')
        .story('Validar lista de Pessoa - lista completa');
        Contrato.contratoRequest(`${patchFixture}pessoa.listacompleta.json`,'pessoa/lista-completa')
    })
    it('Contrato - validar o contrato pessoa - por nome',()=>{
        cy.allure()
        .epic('Teste de Contrato')
        .feature('Pessoa')
        .story('Validar lista de Pessoa - lista por nome');
        Contrato.contratoRequest(`${patchFixture}pessoa.array.json`,'pessoa/byname?nome=Kevin')
    })
    it('Contrato - validar o contrato pessoa - por cpf',()=>{
        cy.allure()
        .epic('Teste de Contrato')
        .feature('Pessoa')
        .story('Validar lista de Pessoa por cpf');
        Contrato.contratoRequest(`${patchFixture}pessoa.simplificado.json`,`pessoa/123456789/cpf`)
    })
    it('Contrato - validar o contrato pessoa - lista simplificada',()=>{
        cy.allure()
        .epic('Teste de Contrato')
        .feature('Pessoa')
        .story('Validar lista de Pessoa - lista simplificada');
        Contrato.contratoRequest(`${patchFixture}pessoa.listasimplificada.json`,'pessoa/')
    })
    it('Contrato - validar o contrato pessoa - lista contatos',()=>{
        cy.allure()
        .epic('Teste de Contrato')
        .feature('Pessoa')
        .story('Validar lista de Pessoa - lista contatos');
        Contrato.contratoRequest(`${patchFixture}pessoa.listacontatos.json`,'pessoa/lista-com-contatos')
    })
})
