import { And } from "cypress-cucumber-preprocessor/steps";
import CustomerDeletePage from "./../pages/CustomerDeletePage"
And("confirme a deleção",()=>{
    CustomerDeletePage.confirmarDeletar()
})