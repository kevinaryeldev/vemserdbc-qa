Feature: Criar Customer
    Background: 
        Given que eu faca login
        And clique em criar customer
    
    @removerCustomerDepois
    Scenario: Criar Customer com sucesso
        And preencho todos os dados
        When clico em criar
        Then devo ser redirecionado para dashboard
        
    Scenario: Criar Customer sem preencher dados
        When clico em criar
        Then devo continuar na pagina de criacao