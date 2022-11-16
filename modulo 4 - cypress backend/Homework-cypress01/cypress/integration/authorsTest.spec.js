/// <reference types="cypress" />
let baseUrl = "https://fakerestapi.azurewebsites.net/api/v1/authors"

function requestPost(idLivro,nome,sobrenome){
    return cy.request({
        method:'POST',
        url:baseUrl,
        failOnStatusCode:false,
        body:{
            idBook: idLivro,
            firstName: nome,
            lastName: sobrenome
        }
    })
}

function requestPut(id,idLivro,nome,sobrenome){
    return cy.request({
        method:'PUT',
        url:`${baseUrl}/${id}`,
        failOnStatusCode:false,
        body:{
            idBook: idLivro,
            firstName: nome,
            lastName: sobrenome
        }
    })
}

function requestDelete(id){
    return cy.request({
        method:'DELETE',
        url:`${baseUrl}/${id}`,
        failOnStatusCode:false,
    })
}

function requestGetAll(){
    return cy.request({
        method:'GET',
        url:baseUrl,
        failOnStatusCode:false
    })
}

function requestGet(id){
    return cy.request({
        method:'GET',
        url:`${baseUrl}/${id}`,
        failOnStatusCode:false
    })
}

function requestGetByIdBook(idBook){
    return cy.request({
        method:'GET',
        url:`${baseUrl}/authors/books/${idBook}`,
        failOnStatusCode:false
    })
}

context('Authors',()=>{
    it('Criar um novo autor',()=>{
        let nome = 'Kevin'
        let sobrenome = 'Tester'
        let idLivro = 10
        requestPost(idLivro,nome,sobrenome).then(
            response =>{
                expect(response.status).to.eq(200)
                expect(response.body.firstName).to.eq( nome)
                expect(response.body.lastName).to.eq(sobrenome)
                expect(response.body.idBook).to.eq(idLivro)
            }
        )
    })

    it('Editar um autor',()=>{
        let nome = 'Kevin 2'
        let sobrenome = 'Tester 2'
        let idLivro = 10
        requestPut(1,idLivro,nome,sobrenome).then(
            response =>{
                expect(response.status).to.eq(200)
                expect(response.body.firstName).to.eq( nome)
                expect(response.body.lastName).to.eq(sobrenome)
                expect(response.body.idBook).to.eq(idLivro)
            }
        )
    })

    it('Pegar todos os autores', ()=>{
        requestGetAll().then(
            response=>{
                expect(response.status).to.eq(200)
                expect(response.body).to.be.a('array')
            }
        )
    })

    it('Pegar um autor',()=>{
        requestGet(1).then(
            response=>{
                expect(response.status).to.eq(200)
                expect(response.body.firstName).to.eq('First Name 1')
                expect(response.body.lastName).to.eq('Last Name 1')
            }
        )
    })

    it('Deletar uma atividade',()=>{
        requestDelete(1).then(
            response=>{
                expect(response.status).to.eq(200)
            }
        )
    })

    it('Pegar autor por idLivro',()=>{
        requestGetByIdBook(1).then(
            response => {
                expect(response.status).to.eq(200)
                expect(response.body).to.be.a('array')
                expect(response.body[0].idBook).to.eq(1)
                expect(response.body[0].firstName).to.eq('First Name 1')
            }
        )
    })
})
