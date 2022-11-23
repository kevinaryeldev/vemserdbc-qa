import {And,When,Then } from "cypress-cucumber-preprocessor/steps";
import DashboardPage from "../pages/DashboardPage";

And("clique em criar customer",()=>{
    DashboardPage.irTelaCriar()
})

Then("devo ser redirecionado para dashboard",()=>{
    DashboardPage.validarEstarNaDashboard()
})

And("pesquise o customer pelo nome",()=>{
    DashboardPage.pesquisarUser()
})
And("clique em Editar",()=>{
    DashboardPage.irTelaEditar()
})
And("clique em Deletar",()=>{
    DashboardPage.irTelaDeletar()
})

When("clique em Info",()=>{
    DashboardPage.irTelaInfo()
})