import BasePage from "./BasePage";
    const name = '.dl-horizontal> dd:nth-child(2)'
    const voltar = '[href="/Dashboard"]'
export default class CustomerInfoPage extends BasePage{
    static validarNome(){
        this.validarText(name,'Kevin')
    }
    static voltarDashboard(){
        this.click(voltar)
    }
}