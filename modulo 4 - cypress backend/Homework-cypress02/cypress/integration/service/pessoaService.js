/// <reference types="cypress" />

const API_BASE = Cypress.env('API_BASE')

export default class PessoaService{

    static deletePessoa(idPessoa){
        return cy.request({
            method:'DELETE',
            url:`${API_BASE}/pessoa/${idPessoa}`,
            failOnStatusCode:false,
            headers:{
                Authorization: Cypress.config('TOKEN')
            }
        })
    }

    static atualizarPessoa(idPessoa,payload){
        return cy.request({
            method:'PUT',
            url:`${API_BASE}/pessoa/${idPessoa}`,
            body: payload,
            failOnStatusCode:false,
            headers:{
                Authorization: Cypress.config('TOKEN')
            }
        })
    }

    static addPessoa(payload){
        return cy.request({
            method:'POST',
            url:`${API_BASE}/pessoa`,
            body:payload,
            failOnStatusCode:false,
            headers:{
                Authorization: Cypress.config('TOKEN')
            }
        })
    }

    static getPessoaAll(pagina = 0,tamanho = 20){
        return cy.request({
            url:`${API_BASE}/pessoa?pagina=${pagina}&tamanhoDasPaginas=${tamanho}`,
            failOnStatusCode:false,
            headers:{
                Authorization: Cypress.config('TOKEN')
            }
        })
    }

    static getPessoaCpf(cpf){
        return cy.request({
            url:`${API_BASE}/pessoa/${cpf}/cpf`,
            failOnStatusCode:false,
            headers:{
                Authorization: Cypress.config('TOKEN')
            }
        })
    }

    static getPessoaRelatorio(idPessoa = null){
        if (idPessoa == null){
            return cy.request({
                url:`${API_BASE}/pessoa/relatorio`,
                failOnStatusCode:false,
                headers:{
                    Authorization: Cypress.config('TOKEN')
                }
            })
        } else {
            return cy.request({
                url:`${API_BASE}/pessoa/relatorio?idPessoa=${idPessoa}`,
                failOnStatusCode:false,
                headers:{
                    Authorization: Cypress.config('TOKEN')
                }
            })
        }
    }

    static getPessoaListaCompleta(id=null){
        if (id ==null ){
            return cy.request({
                url:`${API_BASE}/pessoa/lista-completa`,
                failOnStatusCode:false,
                headers:{
                    Authorization: Cypress.config('TOKEN')
                }
            })
        } else{
            return cy.request({
                url:`${API_BASE}/pessoa/lista-completa?idPessoa=${id}`,
                failOnStatusCode:false,
                headers:{
                    Authorization: Cypress.config('TOKEN')
                }
            })
        }
    }

    static getPessoaListaEnderecos(id = null){
        if(id==null){
            return cy.request({
                url:`${API_BASE}/pessoa/lista-com-enderecos`,
                failOnStatusCode:false,
                headers:{
                    Authorization: Cypress.config('TOKEN')
                }
            })
        }else{
            return cy.request({
                url:`${API_BASE}/pessoa/lista-com-enderecos?idPessoa=${id}`,
                failOnStatusCode:false,
                headers:{
                    Authorization: Cypress.config('TOKEN')
                }
            })
        }
    }

    static getPessoaListaContatos(id = null){
        if(id==null){
            return cy.request({
                url:`${API_BASE}/pessoa/lista-com-contatos`,
                failOnStatusCode:false,
                headers:{
                    Authorization: Cypress.config('TOKEN')
                }
            })
        }else{
            return cy.request({
                url:`${API_BASE}/pessoa/lista-com-contatos?idPessoa=${id}`,
                failOnStatusCode:false,
                headers:{
                    Authorization: Cypress.config('TOKEN')
                }
            })
        }
    }
    static getPessoaNome(nome){
        return cy.request({
            url:`${API_BASE}/pessoa/byname?nome=${nome}`,
            failOnStatusCode:false,
            headers:{
                Authorization: Cypress.config('TOKEN')
            }
        })
    }
}