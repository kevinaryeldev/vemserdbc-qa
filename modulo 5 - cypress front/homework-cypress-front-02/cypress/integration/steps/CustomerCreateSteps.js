import { And,When,Then } from "cypress-cucumber-preprocessor/steps";
import CustomerCreatePage from "./../pages/CustomerCreatePage"

And("preencho todos os dados",()=>{
    CustomerCreatePage.preencherDados()
})
When("clico em criar",()=>{
    CustomerCreatePage.clicarBtnCriarCustomer()
})
Then("devo continuar na pagina de criacao",()=>{
    CustomerCreatePage.validarEstarNaCriacao()
})