/// <reference types="@shelex/cypress-allure-plugin" />
import ContatoData from "../../../fixtures/payload-data/contato";
import ContatoService from './../../service/contatoService'
import PessoaData from './../../../fixtures/payload-data/pessoas'
import PessoaService from "../../service/pessoaService";

const contato = ContatoData.contato1
const contato2 = ContatoData.contato2
const pessoa = PessoaData.pessoa1

context('Contato',()=>{
    context('Criar novo contato',()=>{
        it('Testar criar contato com dados validos',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Contato')
            .story('Criar Contato');
            PessoaService.addPessoa(pessoa).then(({body})=>{
                Cypress.config('idPessoa', body.idPessoa)
            }).then(() =>{
                ContatoService.postContato(Cypress.config('idPessoa'),contato).then(({body,status})=>{
                    expect(status).to.eq(200)
                    expect(body.tipoContato).to.eq(contato.tipoContato)
                }).then(()=>{
                    PessoaService.deletePessoa(Cypress.config('idPessoa'))
                })
            })
        })
        it('Testar criar contato com idPessoa invalido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Contato')
            .story('Criar Contato');
            ContatoService.postContato(0,contato).then(({status,body})=>{
                expect(status).to.eq(404)
                expect(body.message).to.contains('ID')
                expect(body.timestamp).to.exist
            })
        })
    })
    context('Editar contato',()=>{
        it('Editar contato válido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Contato')
            .story('Editar Contato');
            PessoaService.addPessoa(pessoa).then(({body})=>{
                Cypress.config('idPessoa', body.idPessoa)
            }).then(()=>{
                ContatoService.postContato(Cypress.config('idPessoa'),contato).then(({body})=>{
                    Cypress.config('idContato', body.idContato)
                })
            }).then(()=>{
                ContatoService.putContato(Cypress.config('idContato'),contato2).then(({body,status})=>{
                    expect(status).to.eq(200)
                    expect(body.telefone).to.eq(contato2.telefone)
                })
            })
        })
        it('Editar contato com id inválido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Contato')
            .story('Editar Contato');
            ContatoService.putContato(0,contato).then(({body,status})=>{
                expect(status).to.eq(404)
                expect(body.message).to.contains('idContato')
                expect(body.timestamp).to.exist
            })
        })
    })

    context('Deletar contato',()=>{
        it('Deletar contato válido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Contato')
            .story('Deletar Contato');
            PessoaService.addPessoa(pessoa).then(({body})=>{
                Cypress.config('idPessoa', body.idPessoa)
            }).then(()=>{
                ContatoService.postContato(Cypress.config('idPessoa'),contato).then(({body})=>{
                    Cypress.config('idContato', body.idContato)
                })
            }).then(()=>{
                ContatoService.deleteContato(Cypress.config('idContato')).then(({body,status})=>{
                    expect(status).to.eq(200)
                })
            }).then(()=>{
                PessoaService.deletePessoa(Cypress.config('idPessoa'))
            })
        })
        it('Deletar contato com id inválido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Contato')
            .story('Deletar Contato');
            ContatoService.deleteContato(0).then(({body,status})=>{
                expect(status).to.eq(404)
                expect(body.message).to.contains('idContato')
                expect(body.timestamp).to.exist
            })
        })
    })

    context('Pegar contatos',()=>{
        it('Pegar todos os contatos com sucesso',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Contato')
            .story('Pegar Contatos');
            ContatoService.getContato().then(({body,status})=>{
                expect(status).to.eq(200)
                expect(body).to.be.a('array')
            })
        })
        it('Pegar contato por idPessoa com sucesso',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Contato')
            .story('Pegar Contatos');
            PessoaService.addPessoa(pessoa).then(({body})=>{
                Cypress.config('idPessoa', body.idPessoa)
            }).then(() =>{
                ContatoService.postContato(Cypress.config('idPessoa'),contato)
            }).then(()=>{
                ContatoService.getContato(Cypress.config('idPessoa')).then(({status,body})=>{
                    expect(status).to.eq(200)
                    expect(body).to.be.a('array')
                })
            })                
            .then(()=>{
                PessoaService.deletePessoa(Cypress.config('idPessoa'))
            })
        })
        it('Pegar contato por idPessoa invalido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Contato')
            .story('Pegar Contatos');
            ContatoService.getContato(0).then(({status})=>{
                expect(status).to.eq(404)
            })
        })
    })
})