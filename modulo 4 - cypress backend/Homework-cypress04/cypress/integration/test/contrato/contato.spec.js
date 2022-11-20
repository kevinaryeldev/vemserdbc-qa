import Contrato from "../../service/apiPessoa.service"

let patchFixture = 'contrato-contato/contato.listaitens.json'
context('Contrato Contato',()=>{

    beforeEach(()=>{
        cy.criarDados()
    })

    afterEach(()=>{
        cy.deletarDados()
    })

    it('Contrato - validar o contrato contato - lista com endereco',()=>{
        cy.allure()
        .epic('Teste de Contrato')
        .feature('Contato')
        .story('Validar lista de Contatos gerais');
        Contrato.contratoRequest(patchFixture,'contato/')
    })
    it('Contrato - validar o contrato contato - lista por pessoa',()=>{
        cy.allure()
        .epic('Teste de Contrato')
        .feature('Contato')
        .story('Validar lista de Contatos por pessoa');
        Contrato.contratoRequest(patchFixture,`contato/${Cypress.config('idPessoa')}`)
    })
})
