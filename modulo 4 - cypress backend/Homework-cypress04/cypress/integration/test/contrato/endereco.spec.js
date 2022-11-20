import Contrato from "../../service/apiPessoa.service"


let patchFixture = 'contrato-endereco/'

context('Contrato Endereco',()=>{

    beforeEach(()=>{
        cy.criarDados()
    })

    afterEach(()=>{
        cy.deletarDados()
    })

    it('Contrato - validar o contrato endereco - lista com endereco',()=>{
        cy.allure()
        .epic('Teste de Contrato')
        .feature('Endereço')
        .story('Validar lista de Endereço gerais');
        Contrato.contratoRequest(`${patchFixture}endereco.listapaginada.json`,'endereco/')
    })
    it('Contrato - validar o contrato endereco - lista por pais',()=>{
        cy.allure()
        .epic('Teste de Contrato')
        .feature('Endereço')
        .story('Validar lista de Endereço por país');
        Contrato.contratoRequest(`${patchFixture}endereco.listaitens.json`,'endereco/retorna-por-pais?Pa%C3%ADs=Brasil')
    })
    it('Contrato - validar o contrato endereco - lista por pessoa',()=>{
        cy.allure()
        .epic('Teste de Contrato')
        .feature('Endereço')
        .story('Validar lista de Endereço por idPessoa');
        Contrato.contratoRequest(`${patchFixture}endereco.listaitens.json`,`retorna-por-id-pessoa?idPessoa=${Cypress.config('idPessoa')}`)
    })
    it('Contrato - validar o contrato endereco - lista por id Endereco',()=>{
        cy.allure()
        .epic('Teste de Contrato')
        .feature('Endereço')
        .story('Validar lista de Endereço por idEndereço');
        Contrato.contratoRequest(`${patchFixture}endereco.listaitens.json`,`endereco/${Cypress.config('idEndereco')}`)
    })
})
