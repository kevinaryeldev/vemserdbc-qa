Feature: Login
    Scenario: Validar login com sucesso
    Given que preencho o username valido
    And preencho senha valida
    When clico em login

    Scenario: Validar erro login senha invalida
    Given que preencho o username valido
    And preencho senha invalida
    When clico em login
    Then devo ver uma mensagem de erro