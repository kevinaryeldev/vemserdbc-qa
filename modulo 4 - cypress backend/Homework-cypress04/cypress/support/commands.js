// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
import ContatoData from '../fixtures/payload-data/contato';
import PessoaData from '../fixtures/payload-data/pessoas';
import ContatoService from '../integration/service/contatoService';
import PessoaService from './../integration/service/pessoaService'
import EnderecoService from './../integration/service/enderecoService'
import EnderecoData from './../fixtures/payload-data/endereco'
Cypress.Commands.add('login', (login, senha) => {
    cy.request({
    method: 'POST',
    url: `${Cypress.env('API_BASE')}/auth`,
    failOnstatusCode:false,
    body:{
      "login": login,
      "senha": senha
    }
    }).then((response) => {
    Cypress.config('TOKEN', response.body) 
    });
 }
)

Cypress.Commands.add('criarDados',()=>{
  PessoaService.addPessoa(PessoaData.pessoa1).then(({body})=>{
    Cypress.config('idPessoa', body.idPessoa)
    Cypress.config('cpfPessoa', body.cpf)
  }).then(()=>{
    ContatoService.postContato(Cypress.config('idPessoa'),ContatoData.contato1)
  }).then(()=>{
    EnderecoService.adicionarEndereco(Cypress.config('idPessoa'),EnderecoData.endereco1).then(({body})=>{
      Cypress.config('idEndereco', body.idEndereco)
    })
  })
})

Cypress.Commands.add('deletarDados',()=>{
  PessoaService.deletePessoa(Cypress.config('idPessoa'));
})

//
//
// -- This is a child command --
// Cypress.Commands.add('drag', { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add('dismiss', { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite('visit', (originalFn, url, options) => { ... })
