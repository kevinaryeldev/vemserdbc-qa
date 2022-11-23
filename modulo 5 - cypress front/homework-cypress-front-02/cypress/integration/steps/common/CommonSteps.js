import DashboardPage from "./../../pages/DashboardPage"
import CustomerCreatePage from "./../../pages/CustomerCreatePage"
import CustomerDeletePage from "./../../pages/CustomerDeletePage"
import {Before, After } from "cypress-cucumber-preprocessor/steps";
import LoginPage from "./../../pages/LoginPage"
Before({ tags: "@adicionarCustomerAntes" }, () => {
    LoginPage.fazerLogin()
    DashboardPage.pesquisarUser()
    DashboardPage.irTelaCriar()
    CustomerCreatePage.preencherDados()
    CustomerCreatePage.clicarBtnCriarCustomer()
});

After({tags: "@removerCustomerDepois" },()=>{
    DashboardPage.pesquisarUser()
    DashboardPage.irTelaDeletar()
    CustomerDeletePage.confirmarDeletar()
})