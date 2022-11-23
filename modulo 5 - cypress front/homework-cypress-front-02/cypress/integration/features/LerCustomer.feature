Feature: Ler Customer

    @adicionarCustomerAntes @removerCustomerDepois
    Scenario: deletar user com sucesso
        And pesquise o customer pelo nome
        When clique em Info
        Then deve ter os dados corretos no display
        When clicar em voltar
        Then devo ser redirecionado para dashboard