/// <reference types="cypress" />
let baseUrl = "https://fakerestapi.azurewebsites.net/api/v1/books"

function requestPost(titulo,descricao,paginas){
    return cy.request({
        method:'POST',
        url:baseUrl,
        failOnStatusCode:false,
        body:{
            title: titulo,
            description: descricao,
            pageCount: paginas,
            excerpt: "Não sei o que é isso",
            publishDate: new Date()
        }
    })
}

function requestPut(id,titulo,descricao,paginas){
    return cy.request({
        method:'PUT',
        url:`${baseUrl}/${id}`,
        failOnStatusCode:false,
        body:{
            title: titulo,
            description: descricao,
            pageCount: paginas,
            excerpt: "Não sei o que é isso",
            publishDate: new Date()
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

context('Books',()=>{
    it('Criar novo Livro', ()=>
    requestPost('Kevin Tester','Testando com Cypress',120)
        .then(response => {
            expect(response.status).to.eq(200)
            expect(response.body.title).to.eq("Kevin Tester")
        })
    )

    it('Pegar um livro específico',() =>
    requestGet(1).then( response =>{
            expect(response.status).to.eq(200)
            expect(response.body.title).to.eq('Book 1')
            expect(response.body.pageCount).to.eq(100)
            return response.body.id
        })
    )

    it('Editar um Livro',()=>{
        requestPut(1,'Kevin edits', 'Testando edits', 50)
        .then(response =>{
            expect(response.status).to.eq(200)
            expect(response.body.title).to.eq('Kevin edits')
            expect(response.body.description).to.eq('Testando edits')
            expect(response.body.pageCount).to.eq(50)
            return response.body.id
        })
    })

    it('Pegar todos Livros',()=>{
        requestGetAll().then(response=>{
            expect(response.status).to.eq(200)
            expect(response.body).to.be.a('array')
        })
    })
})