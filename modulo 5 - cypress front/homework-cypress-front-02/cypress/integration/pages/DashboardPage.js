import BasePage from "./BasePage"
const btnCriar = '[href="/Customer/Create"]'
const inputPesquisa = '#searching'
const btnPesquisa = '[value="Search"]'
const btnEditar = '.btn.btn-outline-primary'
const btnInfo = '.btn.btn-outline-info'
const btnDeletar = '.btn.btn-outline-danger'

export default class DashboardPage extends BasePage{
    static irTelaCriar(){
        this.click(btnCriar)
    }
    static pesquisarUser(){
        this.preencherInput(inputPesquisa,'Kevin')
        this.click(btnPesquisa)
    }
    static irTelaDeletar(){
        this.click(btnDeletar)
    }
    static irTelaEditar(){
        this.click(btnEditar)
    }
    static irTelaInfo(){
        this.click(btnInfo)
    }
    static validarEstarNaDashboard(){
        this.validarUrl('https://itera-qa.azurewebsites.net/Dashboard')
    }
}