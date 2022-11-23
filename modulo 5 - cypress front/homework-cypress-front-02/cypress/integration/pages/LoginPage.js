import BasePage from "./BasePage"
const username = '#Username'
const password = '#Password'
const loginBtn = '.btn.btn-primary'
const errorMsg = '.alert-danger'

export default class LoginPage extends BasePage {
    static preencherUserValido(){
        this.preencherInput(username,'teste123')
    }
    static preencherSenhaValida(){
        this.preencherInput(password,'12345')
    }
    static preencherSenhaInvalida(){
        this.preencherInput(password,'123465')
    }
    static validarMsgLoginErrado(){
        this.validarText(errorMsg,'Wrong username or password')
    }
    static clicarBtnLogin(){
        this.click(loginBtn)
    }

    static fazerLogin(){
        this.preencherInput(username,'teste123')
        this.preencherInput(password,'12345')
        this.click(loginBtn)
    }
}