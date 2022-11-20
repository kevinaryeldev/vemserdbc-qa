import EnderecoService from './../../service/enderecoService'
import EnderecoData from '../../../fixtures/payload-data/endereco'
import PessoaData from './../../../fixtures/payload-data/pessoas'
import PessoaService from "../../service/pessoaService";
const pessoa = PessoaData.pessoa1
const endereco = EnderecoData.endereco1
context('Endereco',()=>{

    context('Criar Endereco',()=>{
        it('Criar endereco pessoa valida',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Endereço')
            .story('Criar Endereço');
            PessoaService.addPessoa(pessoa).then(({body})=>{
                Cypress.config('idPessoa', body.idPessoa)
            }).then(()=>{
                EnderecoService
                  .adicionarEndereco(Cypress.config('idPessoa'),endereco).then(
                    ({body,status})=>{
                        expect(status).to.eq(200)
                        expect(body.tipo).to.eq(endereco.tipo)
                        expect(body.pais).to.eq(endereco.pais)
                    }
                )
            }).then(()=>{
                    PessoaService.deletePessoa(Cypress.config('idPessoa'))
            })
        })

        it('Criar endereco pessoa invalida',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Endereço')
            .story('Criar Endereço');
            EnderecoService.adicionarEndereco(0,endereco).then(({body,status})=>{
                expect(status).to.eq(404)
                expect(body.message).to.contains('ID')
                expect(body.timestamp).to.exist
            })
        })
    })

    context('Editar Endereco',()=>{
        it('Editar endereco idEndereco valido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Endereço')
            .story('Editar Endereço');
            PessoaService.addPessoa(pessoa).then(({body})=>{
                Cypress.config('idPessoa', body.idPessoa)
            }).then(()=>{
                EnderecoService
                  .adicionarEndereco(Cypress.config('idPessoa'),endereco).then(
                    ({body})=>{
                        Cypress.config('idEndereco', body.idEndereco)
                })
            }).then(()=>{
                let enderecoEditar = EnderecoData.endereco2
                enderecoEditar.idPessoa = Cypress.config('idPessoa')
                EnderecoService
                  .atualizarEndereco(Cypress.config('idEndereco'),enderecoEditar)
                  .then(({status,body})=>{
                    expect(status).to.eq(200)
                    expect(body.tipo).to.eq(enderecoEditar.tipo)
                    expect(body.pais).to.eq(enderecoEditar.pais)
                  })
            })            
            .then(()=>{
                    PessoaService.deletePessoa(Cypress.config('idPessoa'))
            })
        })

        it('Editar endereco idEndereco inválido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Endereço')
            .story('Editar Endereço');
            EnderecoService.atualizarEndereco(0,endereco).then(({status,body})=>{
                expect(status).to.eq(404)
                expect(body.message).to.contains('idEndereco')
                expect(body.timestamp).to.exist
            })
        })
    })

    context('Pegar Endereco',()=>{
        it('Pegar todos enderecos',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Endereço')
            .story('Pegar Endereço');
            EnderecoService.pegarEndereco().then(({status,body})=>{
                expect(status).to.eq(200)
                expect(body.page).to.eq(0)
                expect(body.size).to.eq(20)
                expect(body.content).to.be.a('array')
            })
        })
        it('Pegar endereco por idEndereco',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Endereço')
            .story('Pegar Endereço');
            EnderecoService.pegarEndereco
            PessoaService.addPessoa(pessoa).then(({body})=>{
                Cypress.config('idPessoa', body.idPessoa)
            }).then(()=>{
                EnderecoService
                  .adicionarEndereco(Cypress.config('idPessoa'),endereco).then(
                    ({body})=>{
                        Cypress.config('idEndereco', body.idEndereco)
                })
            }).then(()=>{
                EnderecoService
                 .pegarEndereco(Cypress.config('idEndereco'))
                  .then(({status,body})=>{
                    expect(status).to.eq(200)
                    expect(body.logradouro).to.eq(endereco.logradouro)
                    expect(body.cidade).to.eq(endereco.cidade)
                })
            }).then(()=>{
                PessoaService.deletePessoa(Cypress.config('idPessoa'))
            })
        })
        it('Pegar endereco por idEndereco invalido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Endereço')
            .story('Pegar Endereço');
            EnderecoService.pegarEndereco
            EnderecoService.pegarEndereco(0).then(({status,body})=>{
                expect(status).to.eq(404)
                expect(body.message).to.contains('idEndereco')
                expect(body.timestamp).to.exist
            })
        })
        it('Pegar endereco por idPessoa',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Endereço')
            .story('Pegar Endereço');
            EnderecoService.pegarEndereco
            PessoaService.addPessoa(pessoa).then(({body})=>{
                Cypress.config('idPessoa', body.idPessoa)
            }).then(()=>{
                EnderecoService
                  .adicionarEndereco(Cypress.config('idPessoa'),endereco).then(
                    ({body})=>{
                        Cypress.config('idEndereco', body.idEndereco)
                })
            }).then(()=>{
                EnderecoService
                 .pegarEnderecoPorIdPessoa(Cypress.config('idPessoa'))
                  .then(({status,body})=>{
                    expect(status).to.eq(200)
                    expect(body).to.be.a('array')
                    expect(body[0].idEndereco).to.eq(Cypress.config('idEndereco'))
                })
            }).then(()=>{
                PessoaService.deletePessoa(Cypress.config('idPessoa'))
            })
        })
        it('Pegar endereco por idPessoa invalido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Endereço')
            .story('Pegar Endereço');
            EnderecoService.pegarEndereco
            EnderecoService.pegarEnderecoPorIdPessoa(0).then(({body,status})=>{
                expect(body).to.be.a('array')
                expect(status).to.eq(200)
                expect(body).to.be.empty
            })
        })
        it('Pegar endereco por pais',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Endereço')
            .story('Pegar Endereço');
            EnderecoService.pegarEndereco
            EnderecoService.pegarEnderecoPorPais('Brasil').then(({status,body})=>{
                expect(body).to.be.a('array')
                expect(status).to.eq(200)
            })
        })
    })

    context('Deletar Endereco',()=>{
        it('Deletar endereco idEndereco valido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Endereço')
            .story('Deletar Endereço');
            EnderecoService.pegarEndereco
            PessoaService.addPessoa(pessoa).then(({body})=>{
                Cypress.config('idPessoa', body.idPessoa)
            }).then(()=>{
                EnderecoService
                  .adicionarEndereco(Cypress.config('idPessoa'),endereco).then(
                    ({body})=>{
                        Cypress.config('idEndereco', body.idEndereco)
                })
            }).then(()=>{
                EnderecoService
                  .deleteEndereco(Cypress.config('idEndereco'))
                  .then(({status})=>{
                    expect(status).to.eq(200)
                  })
            })            
            .then(()=>{
                    PessoaService.deletePessoa(Cypress.config('idPessoa'))
            })
        })
        it('Deletar endereco com idEndereco inválido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Endereço')
            .story('Deletar Endereço');
            EnderecoService.pegarEndereco
            EnderecoService.deleteEndereco(0).then(({status,body})=>{
                expect(status).to.eq(404)
                expect(body.message).to.contains('idEndereco')
                expect(body.timestamp).to.exist
            })
        })
    })
})