import PessoaService from './../../service/pessoaService'
import PessoaData from '../../../fixtures/payload-data/pessoas'

const pessoa = PessoaData.pessoa1

context('Pessoa',()=>{

    context('Criar nova pessoa',()=>{
        it('Testar criar nova pessoa com dados válidos', ()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Criar Pessoa');
            PessoaService.addPessoa(pessoa).then(({body,status})=>{
                expect(status).to.eq(200)
                expect(body.nome).to.eq(pessoa.nome)
                expect(body.email).to.eq(pessoa.email)
                return body.idPessoa
            }).then(idPessoa =>{
                PessoaService.deletePessoa(idPessoa).then(({status}) =>
                    expect(status).to.eq(200)
                )
            })
        })

        it('Testar criar nova pessoa sem nome', ()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Criar Pessoa');
            let pessoaTeste = PessoaData.pesssoaSemNome
            PessoaService.addPessoa(pessoaTeste).then(({body,status})=>{
                expect(status).to.eq(400)
                expect(body.status).to.eq(400)
                expect(body.errors).to.be.a('array')
                expect(body.errors[0]).to.have.string('nome')
            })
        })

        it('Testar criar pessoa sem cpf', ()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Criar Pessoa');
            let pessoaTeste = PessoaData.pessoaSemCpf
            PessoaService.addPessoa(pessoaTeste).then(({body,status})=>{
                expect(status).to.eq(400)
                expect(body.status).to.eq(400)
                expect(body.errors).to.be.a('array')
            })
        })

        it('Testar criar pessoa vazio', ()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Criar Pessoa');
            PessoaService.addPessoa({}).then(({body,status})=>{
                expect(status).to.eq(400)
                expect(body.status).to.eq(400)
                expect(body.errors).to.be.a('array')
            })
        })
    })

    context('Atualizar dados pessoa',()=>{
        it('Testar atualizar dados pessoa com sucesso',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Editar Pessoa');
            PessoaService.addPessoa(pessoa).then(({body})=>{
                return body.idPessoa
            }).then(idPessoa => {
                const pessoa2 = PessoaData.pessoa2
                PessoaService.atualizarPessoa(idPessoa,pessoa2).then(
                    ({body}) => {
                        expect(body.nome).to.eq(pessoa2.nome)
                        expect(body.cpf).to.eq(pessoa2.cpf)
                        return body.idPessoa
                    }
                )
            }).then( idPessoa =>{
                PessoaService.deletePessoa(idPessoa).then(({status}) =>
                    expect(status).to.eq(200)
                )
            })
        })

        it('Testar atualizar dados pessoa com id inválido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Editar Pessoa');
            PessoaService.atualizarPessoa(0,pessoa).then(({body,status})=>{
                expect(status).to.eq(404)
                expect(body.status).to.eq(404)
                expect(body.message).to.have.string('ID')
            })
        })

        it('Testar atualizar dados com body vazio',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Editar Pessoa');
            PessoaService.atualizarPessoa(0,{}).then(({body,status})=>{
                expect(status).to.eq(400)                
                expect(body.status).to.eq(400)
            })
        })
    })

    context('Pegar lista de todas pessoas',()=>{
        it('Pegar Lista todas Pessoas',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Pegar Pessoa');
            PessoaService.getPessoaAll().then(({body})=>{
                expect(body.size).to.eq(20)
                expect(body.page).to.eq(0)
                expect(body.content).to.be.a('array')
            })
        })    
    })

    context('Pegar pessoa por cpf',()=>{
        beforeEach(()=>{
            cy.criarDados()
        })
    
        afterEach(()=>{
            cy.deletarDados()
        })
        it('Testar pegar pessoa por cpf com sucesso',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Pegar Pessoa');
            PessoaService.getPessoaCpf(pessoa.cpf).then(({body})=>{
                expect(body.cpf).to.eq(pessoa.cpf)
                expect(body.nome).to.eq(pessoa.nome)
                return body.idPessoa
            })
        })

        it('Testar pegar pessoa por cpf invalido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Pegar Pessoa');
            PessoaService.getPessoaCpf('abc').then(({body,status})=>{
                expect(status).to.eq(400)
                expect(body.status).to.eq(400)
            })
        })

        it('Testar pegar pessoa por cpf inexistente',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Pegar Pessoa');
            PessoaService.getPessoaCpf(0).then(({body,status})=>{
                expect(status).to.eq(400)
                expect(body.status).to.eq(400)
            })
        })

    })


    context('Pegar Relatorio Pessoa',()=>{
        it('Testar pegar Relatorio pessoa com sucesso',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Pegar Pessoa');
            PessoaService.addPessoa(pessoa).then(response =>{
                expect(response.status).to.eq(200)
                return response.body.idPessoa
            }).then(idPessoa =>{
                PessoaService.getPessoaRelatorio(idPessoa)
                    .then(({status,body})=>{
                        expect(status).to.eq(200)
                        expect(body).to.be.a('array')
                        expect(body[0].nomePessoa).to.eq(pessoa.nome)
                        expect(body[0].email).to.eq(pessoa.email)
                        return body[0].idPessoa
                }).then(idPessoa=>{
                    PessoaService.deletePessoa(idPessoa)
                })
            })
        })

        it('Testar pegar Relatorio pessoa todos',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Pegar Pessoa');
            PessoaService.getPessoaRelatorio().then(({status,body})=>{
                expect(status).to.eq(200)
                expect(body).to.be.a('array')
            })
        })
        it('Testar pegar Relatorio pessoa com id invalido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Pegar Pessoa');
            PessoaService.getPessoaRelatorio(0).then(({status,body})=>{
                expect(status).to.eq(200)
                expect(body).to.be.a('array')
                expect(body).to.be.empty
            })
        })
    })
    
    context('Pegar lista completa pessoa',()=>{
        it('Testar pegar lista completa pessoa sem id',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Pegar Pessoa');
            PessoaService.getPessoaListaCompleta().then(({body,status})=>{
                expect(status).to.eq(200)
                expect(body).to.be.a('array')
            })
        })
        it('Testar pegar lista completa pessoa com id invalido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Pegar Pessoa');
            PessoaService.getPessoaListaCompleta(0).then(({body,status})=>{
                expect(status).to.eq(200)
                expect(body).to.be.a('array')
                expect(body).to.be.empty
            })
        })
        it('Testar pegar lista completa pessoa com id valido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Pegar Pessoa');
            PessoaService.addPessoa(pessoa).then(({body})=>{
                return body.idPessoa
            }).then(idPessoa=>{
                PessoaService.getPessoaListaCompleta(idPessoa).then(({body,status})=>{
                    expect(status).to.eq(200)
                    expect(body).to.be.a('array')
                    expect(body[0].nome).to.eq(pessoa.nome)
                    return body[0].idPessoa
                }).then(idPessoa=>{
                    PessoaService.deletePessoa(idPessoa)
                })
            })
        })
    })

    context('Pegar lista enderecos pessoa',()=>{
        it('Testar pegar lista enderecos pessoa com sucesso',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Pegar Pessoa');
            PessoaService.getPessoaListaEnderecos().then(({body,status})=>{
                expect(status).to.eq(200)
                expect(body).to.be.a('array')
            })
        })
        it('Testar pegar lista enderecos pessoa com id invalido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Pegar Pessoa');
            PessoaService.getPessoaListaEnderecos(0).then(({body,status})=>{
                expect(status).to.eq(404)
                expect(body.message).to.exist
                expect(body.timestamp).to.exist
            })
        })
        it('Testar pegar lista enderecos pessoa com id valido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Pegar Pessoa');
            PessoaService.addPessoa(pessoa).then(({body})=>{
                return body.idPessoa
            }).then(idPessoa=>{
                PessoaService.getPessoaListaEnderecos(idPessoa).then(({body,status})=>{
                    expect(status).to.eq(200)
                    expect(body).to.be.a('array')
                    expect(body[0].nome).to.eq(pessoa.nome)
                    return body[0].idPessoa
                }).then(idPessoa=>{
                    PessoaService.deletePessoa(idPessoa)
                })
            })
        })
    })

    context('Pegar lista pessoa com contatos',()=>{
        it('Testar pegar pessoa lista com contatos com sucesso',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Pegar Pessoa');
            PessoaService.getPessoaListaContatos().then(({body,status})=>{
                expect(status).to.eq(200)
                expect(body).to.be.a('array')
            })
        })
        it('Testar pegar pessoa lista com contatos com id invalido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Pegar Pessoa');
            PessoaService.getPessoaListaContatos(0).then(({body,status})=>{
                expect(status).to.eq(404)
                expect(body.message).to.exist
                expect(body.timestamp).to.exist
            })
        })
        it('Testar pegar lista pessoa com contatos com id valido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Pegar Pessoa');
            PessoaService.addPessoa(pessoa).then(({body})=>{
                return body.idPessoa
            }).then(idPessoa=>{
                PessoaService.getPessoaListaContatos(idPessoa).then(({body,status})=>{
                    expect(status).to.eq(200)
                    expect(body).to.be.a('array')
                    expect(body[0].nome).to.eq(pessoa.nome)
                    return body[0].idPessoa
                }).then(idPessoa=>{
                    PessoaService.deletePessoa(idPessoa)
                })
            })
        })
    })

    context('Pegar pessoa por nome',()=>{
        it('Testar pegar pessoa por nome valido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Pegar Pessoa');
            PessoaService.addPessoa(pessoa).then(response =>{
                expect(response.status).to.eq(200)
            }).then( ()=>{
                PessoaService.getPessoaNome(pessoa.nome).then(({body})=>{
                    expect(body).to.be.a('array')
                    expect(body[0].nome).to.eq(pessoa.nome)
                    expect(body[0].email).to.eq(pessoa.email)
                    return body[0].idPessoa
                }).then( idPessoa => {
                    PessoaService.deletePessoa(idPessoa)
                })
            })
        })
        it('Testar pegar pessoa por nome invalido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Pegar Pessoa');
            PessoaService.getPessoaNome('kaklfiqwohio').then(({status,body})=>{
                expect(status).to.eq(200)
                expect(body).to.be.a('array')
                expect(body).to.be.empty
            })
        })
    })

    context('Deletar pessoa',()=>{
        it('Testar deletar pessoa com id válido', ()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Deletar Pessoa');
            PessoaService.addPessoa(pessoa).then(({body})=>{
                return body.idPessoa
            }).then(idPessoa =>{
                PessoaService.deletePessoa(idPessoa).then(({status}) =>
                    expect(status).to.eq(200)
                )
            })
        })
        it('Testar deletar pessoa com id inválido',()=>{
            cy.allure()
            .epic('Teste de Aceitação')
            .feature('Pessoa')
            .story('Deletar Pessoa');
            PessoaService.deletePessoa(0).then(({status,body}) =>{
                expect(status).to.eq(404)               
                expect(body.status).to.eq(404)
                expect(body.timestamp).to.exist
                expect(body.message).to.be.a('string')
            })
        })
    })
})