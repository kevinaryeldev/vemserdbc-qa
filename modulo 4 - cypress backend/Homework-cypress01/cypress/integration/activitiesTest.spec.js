/// <reference types="cypress" />
let baseUrl = "https://fakerestapi.azurewebsites.net/api/v1/activities"

function requestPost(titulo,completed){
    return cy.request({
        method:'POST',
        url:baseUrl,
        failOnStatusCode:false,
        body:{
            title: titulo,
            dueDate: "2022-11-18T03:03:31.810Z",
            completed: completed
        }
    })
}

function requestPut(id,titulo,completed){
    return cy.request({
        method:'PUT',
        url:`${baseUrl}/${id}`,
        failOnStatusCode:false,
        body:{
            title: titulo,
            dueDate: "2022-11-18T03:03:31.810Z",
            completed:completed
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

context('Activities',()=>{
    it('Criar nova atividade',()=>{
        let title = 'Kevin Tester'
        requestPost(title,true).then(
            response =>{
                expect(response.status).to.eq(200)
                expect(response.body.title).to.eq(title)
                expect(response.body.completed).to.eq(true)
            }
        )
    })

    it('Editar uma atividade',()=>{
        let title = 'Kevin Tester 2'
        let completed = false
        requestPut(1,title,completed).then(
            response =>{
                expect(response.status).to.eq(200)
                expect(response.body.title).to.eq(title)
                expect(response.body.completed).to.eq(completed)
            }
        )
    })

    it('Pegar todas atividades', ()=>{
        requestGetAll().then(
            response=>{
                expect(response.status).to.eq(200)
                expect(response.body).to.be.a('array')
            }
        )
    })

    it('Pegar uma atividade',()=>{
        requestGet(1).then(
            response=>{
                expect(response.status).to.eq(200)
                expect(response.body.title).to.eq('Activity 1')
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
})
