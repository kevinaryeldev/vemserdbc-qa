import CustomerInfoPage from "./../pages/CustomerInfoPage"
import {When,Then } from "cypress-cucumber-preprocessor/steps";
Then("deve ter os dados corretos no display",()=>{
    CustomerInfoPage.validarNome()
})
When("clicar em voltar",()=>{
    CustomerInfoPage.voltarDashboard()
})