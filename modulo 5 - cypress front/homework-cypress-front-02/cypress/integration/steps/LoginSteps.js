import { Given,And,When,Then } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "../pages/LoginPage";

Given ("que eu faca login",()=>{
    LoginPage.fazerLogin()
})

Given("que preencho o username valido",()=>{
    LoginPage.preencherUserValido()
})
And("preencho senha valida",()=>{
    LoginPage.preencherSenhaValida()
})
And("preencho senha invalida",()=>{
    LoginPage.preencherSenhaInvalida()
})
When("clico em login",()=>{
    LoginPage.clicarBtnLogin()
})
Then("devo ver uma mensagem de erro",()=>{
    LoginPage.validarMsgLoginErrado()
})