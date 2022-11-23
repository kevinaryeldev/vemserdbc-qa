import BasePage from "./BasePage"
const inputName = '#Name'
const inputCompany = '#Company'
const inputAddress = '#Address'
const inputCity = '#City'
const inputPhone = '#Phone'
const inputEmail = '#Email'
const btnSave = '[value="Save"]'

export default class CustomerEditPage extends BasePage{
    static editarDados(){
        this.preencherInput(inputName, 'Kevin tester 2')
        this.preencherInput(inputCompany, 'Digital Business Company')
    }
    static editarLimparCampos(){
        this.limparInput(inputName)
        this.limparInput(inputCompany)
        this.limparInput(inputAddress)
        this.limparInput(inputCity)
        this.limparInput(inputPhone)
        this.limparInput(inputEmail)
    }
    static clicarBtnSalvar(){
        this.click(btnSave)
    }
    static validarEstarNaEdicao(){
        this.validarUrl('https://itera-qa.azurewebsites.net/Customer/Edit/')
    }
}
