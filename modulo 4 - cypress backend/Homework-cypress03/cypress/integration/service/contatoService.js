/// <reference types="cypress" />
const API_BASE = Cypress.env('API_BASE')

export default class ContatoService{
    static deleteContato(idContato){
        return cy.request({
            method:'DELETE',
            url:`${API_BASE}/contato/${idContato}`,
            failOnStatusCode:false,
            headers:{
                Authorization: Cypress.config('TOKEN')
            }
        })
    }

    static getContato(idPessoa = null){
        if (idPessoa == null){
            return cy.request({
                url:`${API_BASE}/contato`,
                failOnStatusCode:false,
                headers:{
                    Authorization: Cypress.config('TOKEN')
                }
            })
        } else{
            return cy.request({
                url:`${API_BASE}/contato/${idPessoa}`,
                failOnStatusCode:false,
                headers:{
                    Authorization: Cypress.config('TOKEN')
                }
            })
        }
    }

    static postContato(idPessoa,payload){
        return cy.request({
            method:'POST',
            url:`${API_BASE}/contato/${idPessoa}`,
            failOnStatusCode:false,
            body: payload,
            headers:{
                Authorization: Cypress.config('TOKEN')
            }
        })
    }

    static putContato(idContato,payload){
        return cy.request({
            method:'PUT',
            url:`${API_BASE}/contato/${idContato}`,
            failOnStatusCode:false,
            body: payload,
            headers:{
                Authorization: Cypress.config('TOKEN')
            }
        })
    }
}