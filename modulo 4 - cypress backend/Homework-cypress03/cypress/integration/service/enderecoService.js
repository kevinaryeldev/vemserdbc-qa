/// <reference types="cypress" />
const API_BASE = Cypress.env('API_BASE')

export default class EnderecoService{
    static deleteEndereco(idEndereco){
        return cy.request({
            method:'DELETE',
            url:`${API_BASE}/endereco/${idEndereco}`,
            failOnStatusCode:false,
            headers:{
                Authorization: Cypress.config('TOKEN')
            }
        })
    }

    static atualizarEndereco(idEndereco,payload){
        return cy.request({
            method:'PUT',
            url:`${API_BASE}/endereco/${idEndereco}`,
            body: payload,
            failOnStatusCode:false,
            headers:{
                Authorization: Cypress.config('TOKEN')
            }
        })
    }

    static adicionarEndereco(idPessoa,payload){
        return cy.request({
            method:'POST',
            url:`${API_BASE}/endereco/${idPessoa}`,
            body:payload,
            failOnStatusCode:false,
            headers:{
                Authorization: Cypress.config('TOKEN')
            }
        })
    }

    static pegarEndereco(idEndereco = null){
        let urlGetEndereco;
        idEndereco == null?
         urlGetEndereco == `${API_BASE}/endereco` :
          urlGetEndereco == `${API_BASE}/endereco/${idEndereco}`
        return cy.request({
            url:urlGetEndereco,
            failOnStatusCode:false,
            headers:{
                Authorization: Cypress.config('TOKEN')
            }
        })
    }

    static pegarEnderecoPorPais(nomePais){
        return cy.request({
            url:`${API_BASE}/endereco/retorna-por-pais`,
            qs:{
                País:nomePais
            },
            failOnStatusCode:false,
            headers:{
                Authorization: Cypress.config('TOKEN')
            }
        })
    }

    static pegarEnderecoPorIdPessoa(idPessoa){
        return cy.request({
            url:`${API_BASE}/endereco/retorna-por-id-pessoa`,
            qs:{
                idPessoa:idPessoa
            },
            failOnStatusCode:false,
            headers:{
                Authorization: Cypress.config('TOKEN')
            }
        })
    }
}