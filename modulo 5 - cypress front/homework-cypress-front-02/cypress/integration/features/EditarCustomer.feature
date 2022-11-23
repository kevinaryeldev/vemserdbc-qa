Feature: Editar Customer
    @adicionarCustomerAntes
    @removerCustomerDepois
    Scenario: Editar User com sucesso
        And pesquise o customer pelo nome
        And clique em Editar
        And altere os dados
        When clico no botao save
        Then devo ser redirecionado para dashboard

    @adicionarCustomerAntes
    Scenario: Editar user deletando todos os campos
    And pesquise o customer pelo nome
    And clique em Editar
    And delete todos os campos
    When clico no botao save
    Then devo continuar na pagina de editar