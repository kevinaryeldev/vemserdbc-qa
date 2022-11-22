import BasePage from "./BasePage"
const username = '#Username'
const password = '#Password'
const loginBtn = '.btn.btn-primary'
const errorMsg = '.alert-danger'

export default class LoginPage extends BasePage {
    static loginNoSistema(){
        this.preencherInput(username,'teste123')
        this.preencherInput(password,'12345')
        this.click(loginBtn)
    }
    static loginSenhaErrada(){
        this.preencherInput(username,'teste123')
        this.preencherInput(password,'123465')
        this.click(loginBtn)
        this.validarText(errorMsg,'Wrong username or password')
    }
}