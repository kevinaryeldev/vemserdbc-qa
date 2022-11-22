import DashboardPage from "../pages/DashboardPage";
import CustomerCreatePage from "../pages/CustomerCreatePage";
import LoginPage from "../pages/LoginPage";
import DeletePage from '../pages/CustomerDeletePage'
import CustomerEditPage from "../pages/CustomerEditPage";
import CustomerInfoPage from "../pages/CustomerInfoPage";
context('Testar CRUD',()=>{
    function criarDados(){
        DashboardPage.irTelaCriar()
        CustomerCreatePage.criarCustomer()
    }
    function deletarDados(){
        DashboardPage.pesquisarUser()
        DashboardPage.irTelaDeletar()
        DeletePage.confirmarDeletar()
    }
    beforeEach(()=>{
        LoginPage.loginNoSistema()
    })
    describe('Criar Customer',()=>{
        it('Criar Customer com sucesso',()=>{
            DashboardPage.irTelaCriar()
            CustomerCreatePage.criarCustomer()
            DashboardPage.validarEstarNaDashboard()
            //Limpando dados
            deletarDados()
        })
        it('Criar Customer vazio',()=>{
            DashboardPage.irTelaCriar()
            CustomerCreatePage.criarCustomerVazio()
            CustomerCreatePage.validarEstarNaCriacao()
        })
    })
    describe('Ler Customer',()=>{
        beforeEach(()=>{
            criarDados()
        })
        afterEach(()=>{
            deletarDados()
        })
        it('Ler Customer com sucesso',()=>{
            DashboardPage.pesquisarUser()
            DashboardPage.irTelaInfo()
            CustomerInfoPage.validarNome()
            CustomerInfoPage.voltarDashboard()
        })
    })
    describe('Editar Customer',()=>{
        beforeEach(()=>{
            criarDados()
            DashboardPage.pesquisarUser()
            DashboardPage.irTelaEditar()
        })
        it('Editar Customer com sucesso',()=>{
            CustomerEditPage.editarDados()
            DashboardPage.validarEstarNaDashboard()
            deletarDados()
        })
        it('Editar Customer limpando todos campos',()=>{
            CustomerEditPage.editarLimparCampos()
            CustomerEditPage.validarEstarNaEdicao()
        })
    })
    describe('Deletar Customer',()=>{
        beforeEach(()=>{
            criarDados()
        })
        it('Deletar Customer com sucesso',()=>{
            DashboardPage.pesquisarUser()
            DashboardPage.irTelaDeletar()
            DeletePage.confirmarDeletar()
        })
    })
})