#language: en

Feature: Delivery Registration
  As an API User
  I want to register a new delivery
  To save it correctly

  Scenario: Delivery Registration Successful
    Given the following registration data:
      | campo          | valor        |
      | numeroPedido   | 1            |
      | nomeEntregador | Ana Silva    |
      | statusEntrega  | EM_SEPARACAO |
      | dataEntrega    | 2024-08-22   |
    When I send the request to the endpoint "/entregas" to register a delivery
    Then response status is 201

