#language: en

  Feature: Delete entrega
    Background: Delivery Registration Successful
      Given the following registration data:
        | campo          | valor        |
        | numeroPedido   | 1            |
        | nomeEntregador | Ana Silva    |
        | statusEntrega  | EM_SEPARACAO |
        | dataEntrega    | 2024-08-22   |
      When I send the request to the endpoint "/entregas" to register a delivery
      Then response status is 201

    Scenario: Entrega can be deleted
      Given that I recover an ID created on a background
      When I send the ID to the request endpoint "/entregas" to delete entregas
      Then response status is 204
