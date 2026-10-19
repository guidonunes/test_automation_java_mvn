#language: en

  Feature: Validate entrega contract registration
    Scenario: ValidDelivery Registration Successful
      Given the following registration data:
        | campo          | valor        |
        | numeroPedido   | 1            |
        | nomeEntregador | Ana Silva    |
        | statusEntrega  | EM_SEPARACAO |
        | dataEntrega    | 2024-08-22   |
      When I send the request to the endpoint "/entregas" to register a delivery
      Then response status is 201
      And the selected contract will be "Cadastro de entrega bem sucedida"
      Then the request's response should match the selected contract