import BasePage from "./BasePage";

const btnConfirmarDeletar = '[value="Delete"]'

export default class DeletePage extends BasePage{
    static confirmarDeletar(){
        this.click(btnConfirmarDeletar)
    }
}