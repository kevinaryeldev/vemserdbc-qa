import LoginPage from "../pages/LoginPage";

context('Login',()=>{
    it('Validar login com sucesso',()=>{
        LoginPage.loginNoSistema()
    })
    it('Validar login com senha incorreta',()=>{
        LoginPage.loginSenhaErrada()
    })
})