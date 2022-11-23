import CustomerEditPage from "./../pages/CustomerEditPage"
import { And,When,Then } from "cypress-cucumber-preprocessor/steps";

And("altere os dados",()=>{
    CustomerEditPage.editarDados()
})

And("delete todos os campos",()=>{
    CustomerEditPage.editarLimparCampos()
})
When("clico no botao save",()=>{
    CustomerEditPage.clicarBtnSalvar()
})
Then("devo continuar na pagina de editar",()=>{
    CustomerEditPage.validarEstarNaEdicao()
})