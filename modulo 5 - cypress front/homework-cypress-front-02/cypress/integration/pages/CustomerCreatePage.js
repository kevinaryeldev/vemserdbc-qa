import BasePage from "./BasePage"
const inputName = '#Name'
const inputCompany = '#Company'
const inputAddress = '#Address'
const inputCity = '#City'
const inputPhone = '#Phone'
const inputEmail = '#Email'
const btnCreate = '[value="Create"]'

export default class CustomerCreatePage extends BasePage{
    static preencherDados(){
        this.preencherInput(inputName,'Kevin Tester')
        this.preencherInput(inputCompany, 'Vem Ser DBC')
        this.preencherInput(inputAddress,'Rua tal, numero 123')
        this.preencherInput(inputCity,'Salvador')
        this.preencherInput(inputPhone,'(71)97171-7171')
        this.preencherInput(inputEmail,'kevinqatester@proton.me')
    }
    static clicarBtnCriarCustomer(){
        this.click(btnCreate)
    }
    static validarEstarNaCriacao(){
        this.validarUrl('https://itera-qa.azurewebsites.net/Customer/Create')
    }
}