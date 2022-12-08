@transactionAsAdmin
Feature: Admin Transaction
  Scenario Outline: Get single transaction with valid id
    Given Get transaction with valid parameter <id>
    When Send request get transaction
    Then Response API should return 200 OK
    And Validate single transaction json schema
    And Json response contain "Success get detail transaction data"
    Examples:
      | id |
      |230 |

  Scenario Outline: Get single transaction with invalid id
    Given Get transaction with invalid parameter <id>
    When Send request get transaction
    Then Response API should return 404 Not Found
    And Validate invalid single transaction json schema
    And Json response contain "Not Found"
    Examples:
      | id           |
      | 890939399212 |

  Scenario Outline: Get single transaction with invalid token auth
    Given Get transaction with invalid token auth with parameter <id>
    When Send request get transaction
    Then Response API should return 401 Unauthorized
    And Validate invalid json schema
    And Json response contain "invalid or expired jwt"
    Examples:
      | id  |
      | 233 |

  Scenario: Get All transaction with valid token auth
    Given Get All transaction with valid token auth
    When Send request get all transaction
    Then Response API should return 200 OK
    And Validate get all transaction json schema
    And Json response contain "Success get all transaction data"

  Scenario: Get All transaction with invalid token auth
    Given Get all transaction with invalid token auth
    When Send request get all transaction
    Then Response API should return 401 Unauthorized
    And Validate invalid json schema
    And Json response contain "invalid or expired jwt"

  Scenario Outline: Put Update transaction with valid id
    Given Set put update transaction with valid <id>
    When Send request put transaction
    Then Response API should return 201 Created
    And Validate update transaction json schema
    And Json response contain "Success update transaction status"
    Examples:
      | id  |
      | 230 |

  Scenario Outline: Put Update transaction with invalid token auth
    Given Set put update transaction with invalid token auth valid <id>
    When Send request put transaction
    Then Response API should return 401 Unauthorized
    And Validate invalid json schema
    And Json response contain "invalid or expired jwt"
    Examples:
      | id |
      |230 |

  Scenario: Delete transaction with valid id
    Given Set delete transaction with valid 1
    When Send request delete transaction
    Then Response API should return 202 Accepted
    And Validate delete json schema
    And Json response contain "Success Cancel Transaction Service"