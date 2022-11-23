Feature: Deletar Customer
    @adicionarCustomerAntes
    Scenario: deletar user com sucesso
        And pesquise o customer pelo nome
        And clique em Deletar
        And confirme a deleção
        Then devo ser redirecionado para dashboard