@tugas
Feature: History
  Scenario: history user transactions with valid token
    Given Get history with valid token
    When send History request  with valid path
    Then Response Api should return 200 OK
    And Validation Json Schema History Success
    And response body "Success get all transaction data"

Scenario: history user transactions with invalid path
    Given Get  history with valid token
    When send request with invalid path
    Then  Response Api should return 404 Not Found
    And Validation Json Schema History Not Found
    And response body "Not Found"

  Scenario: history user transactions with expired token
    Given Get  history with expired token
    When send request with valid path
    Then  Response Api should return 401 Unauthorized
    And Validation Json Schema Expired Token
    And response body "invalid or expired jwt"