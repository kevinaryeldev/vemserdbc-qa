import PessoaService from './../service/pessoaService.js'
import PessoaData from './../../fixtures/pessoas.js'

const pessoa = PessoaData.pessoa1

context('Pessoa',()=>{

    context('Criar nova pessoa',()=>{
        it('Testar criar nova pessoa com dados válidos', ()=>{
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
            let pessoaTeste = PessoaData.pesssoaSemNome
            PessoaService.addPessoa(pessoaTeste).then(({body,status})=>{
                expect(status).to.eq(400)
                expect(body.status).to.eq(400)
                expect(body.errors).to.be.a('array')
                expect(body.errors[0]).to.have.string('nome')
            })
        })

        it('Testar criar pessoa sem cpf', ()=>{
            let pessoaTeste = PessoaData.pessoaSemCpf
            PessoaService.addPessoa(pessoaTeste).then(({body,status})=>{
                expect(status).to.eq(400)
                expect(body.status).to.eq(400)
                expect(body.errors).to.be.a('array')
            })
        })

        it('Testar criar pessoa vazio', ()=>{
            PessoaService.addPessoa({}).then(({body,status})=>{
                expect(status).to.eq(400)
                expect(body.status).to.eq(400)
                expect(body.errors).to.be.a('array')
            })
        })
    })

    

    context('Atualizar dados pessoa',()=>{
        it('Testar atualizar dados pessoa com sucesso',()=>{
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
            PessoaService.atualizarPessoa(0,pessoa1).then(({body,status})=>{
                expect(status).to.eq(404)
                expect(body.status).to.eq(404)
                expect(body.message).to.have.string('ID')
            })
        })

        it('Testar atualizar dados com body vazio',()=>{
            PessoaService.atualizarPessoa(134,{}).then(({body,status})=>{
                expect(status).to.eq(400)                
                expect(body.status).to.eq(404)
                expect(body.erros).to.be.a('array')
            })
        })
    })

    context('Pegar lista de todas pessoas',()=>{
        it('Pegar Lista todas Pessoas',()=>{
            PessoaService.getPessoaAll().then(({body})=>{
                expect(body.size).to.eq(20)
                expect(body.page).to.eq(0)
                expect(body.content).to.be.a('array')
            })
        })    
    })


    context('Pegar pessoa por cpf',()=>{
        it('Testar pegar pessoa por cpf com sucesso',()=>{
            PessoaService.addPessoa(pessoa).then(response =>{
                expect(response.status).to.eq(200)
            }).then( ()=>{
                PessoaService.getPessoaCpf(pessoa.cpf).then(({body})=>{
                    expect(body.cpf).to.eq(pessoa.cpf)
                    expect(body.nome).to.eq(pessoa.nome)
                    return body.idPessoa
                }).then(idPessoa=> {
                    PessoaService.deletePessoa(idPessoa)
                })
            })
        })

        it('Testar pegar pessoa por cpf invalido',()=>{
            PessoaService.getPessoaCpf('123').then(({body,status})=>{
                expect(status).to.eq(400)
                expect(body.status).to.eq(400)
            })
        })

        it('Testar pegar pessoa por cpf inexistente',()=>{
            PessoaService.getPessoaCpf('723416589').then(({body,status})=>{
                expect(status).to.eq(400)
                expect(body.status).to.eq(400)
            })
        })

    })


    context('Pegar Relatorio Pessoa',()=>{
        it('Testar pegar Relatorio pessoa com sucesso',()=>{
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
            PessoaService.getPessoaRelatorio().then(({status,body})=>{
                expect(status).to.eq(200)
                expect(body).to.be.a('array')
            })
        })
        it('Testar pegar Relatorio pessoa com id invalido',()=>{
            PessoaService.getPessoaRelatorio(0).then(({status,body})=>{
                expect(status).to.eq(200)
                expect(body).to.be.a('array')
                expect(body).to.be.empty
            })
        })
    })
    
    context('Pegar lista completa pessoa',()=>{
        it('Testar pegar lista completa pessoa sem id',()=>{
            PessoaService.getPessoaListaCompleta().then(({body,status})=>{
                expect(status).to.eq(200)
                expect(body).to.be.a('array')
            })
        })
        it('Testar pegar lista completa pessoa com id invalido',()=>{
            PessoaService.getPessoaListaCompleta(0).then(({body,status})=>{
                expect(status).to.eq(200)
                expect(body).to.be.a('array')
                expect(body).to.be.empty
            })
        })
        it('Testar pegar lista completa pessoa com id valido',()=>{
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
            PessoaService.getPessoaListaEnderecos().then(({body,status})=>{
                expect(status).to.eq(200)
                expect(body).to.be.a('array')
            })
        })
        it('Testar pegar lista enderecos pessoa com id invalido',()=>{
            PessoaService.getPessoaListaEnderecos().then(({body,status})=>{
                expect(status).to.eq(200)
                expect(body).to.be.a('array')
                expect(body).to.be.empty
            })
        })
        it('Testar pegar lista enderecos pessoa com id valido',()=>{
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
            PessoaService.getPessoaListaContatos().then(({body,status})=>{
                expect(status).to.eq(200)
                expect(body).to.be.a('array')
            })
        })
        it('Testar pegar pessoa lista com contatos com id invalido',()=>{
            PessoaService.getPessoaListaContatos(0).then(({body,status})=>{
                expect(status).to.eq(200)
                expect(body).to.be.a('array')
                expect(body).to.be.empty
            })
        })
        it('Testar pegar lista pessoa com contatos com id valido',()=>{
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
            PessoaService.getPessoaNome('kaklfiqwohio').then(({status,body})=>{
                expect(status).to.eq(200)
                expect(body).to.be.a('array')
                expect(body).to.be.empty
            })
        })
    })

    context('Deletar pessoa',()=>{
        it('Testar deletar pessoa com id válido', ()=>{
            PessoaService.addPessoa(pessoa).then(({body})=>{
                return body.idPessoa
            }).then(idPessoa =>{
                PessoaService.deletePessoa(idPessoa).then(({status}) =>
                    expect(status).to.eq(200)
                )
            })
        })
        it('Testar deletar pessoa com id inválido',()=>{
            PessoaService.deletePessoa(0).then(({status,body}) =>{
                expect(status).to.eq(404)               
                expect(body.status).to.eq(404)
                expect(body.timestamp).to.exist
                expect(body.message).to.be.a('string')
            })
        })
    })
})