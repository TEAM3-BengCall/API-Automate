@TransactionUser
Feature: Transaction user

  @POSTTransactionPositive
  Scenario: Transaction user with valid path
    Given user create transaction with valid json
    When Send request valid path transaction
    Then Status code 201 Created
    And response body valid path transaction massage "Success creating new service"
    And Validation Transaction valid path

  @POSTTransactionNegative
  Scenario: Transaction user with invalid path
    Given user create transaction with valid json
    When Send request invalid path transaction user
    Then Status code 404 not found
    And invalid path Response body should contain massage "Not Found"
    And validation invalid path transaction user

  @POSTTransactionNegative
  Scenario: Transaction user with invalid location id
    Given user create transaction with invalid location id
    When Send request valid path transaction
    Then Status code 201 Created
    And response body with invalid location id massage "Success creating new service"
    And Validation Transaction with invalid location id

  @POSTTransactionNegative
  Scenario: Transaction user with invalid vehicle id
    Given user create transaction with invalid vehicle id
    When Send request valid path transaction
    Then Status code 201 Created
    And response body with invalid vehicle id massage "Success creating new service"
    And Validation Transaction with invalid vehicle id

  @POSTTransactionNegative
  Scenario: Transaction user with invalid service id
    Given user create transaction with invalid service id
    When Send request valid path transaction
    Then Status code 201 Created
    And response body with invalid service id massage "Success creating new service"
    And Validation Transaction with invalid service id

  @POSTTransactionNegative
  Scenario: Transaction user without date
    Given user create transaction without date
    When Send request valid path transaction
    Then Status code 400 not found
    And response body without date massage "there's input empty"
    And Validation Transaction without date

  @POSTTransactionNegative
  Scenario: Transaction user without phone number
    Given user create transaction without phone number
    When Send request valid path transaction
    Then Status code 400 not found
    And response body without phone number massage "there's input empty"
    And Validation Transaction without phone number

  @POSTTransactionNegative
  Scenario: Transaction user without Address
    Given user create transaction without address
    When Send request valid path transaction
    Then Status code 400 not found
    And response body without address massage "there's input empty"
    And Validation Transaction without address

  @GETTransactionPositive
  Scenario: Get on going Transaction with valid parameter and valid token
    Given User get on going transaction
    When send request valid path ongoing transaction
    Then Status code 200 OK
    And response body on going transaction massage "Success get my transaction", id 414 and invoice 3421
    And Validation on going transaction

  @GETTransactionNegative
  Scenario: Get on going Transaction with invalid parameter
    Given User get on going transaction with invalid id
    When send request invalid path ongoing transaction
    Then Status code 500 Internal Server Error
    And response body on going transaction with invalid id massage "id not valid"
    And Validation on going transaction with invalid parameter id

  @GETTransactionNegative
  Scenario: Get on going Transaction with invalid token
    Given User get on going transaction with invalid token
    When send request valid path ongoing transaction
    Then Status code 401 Unauthorized
    And response body on going transaction with invalid token massage "invalid or expired jwt"
    And Validation on going transaction with invalid token

  @GETTransactionPositive
  Scenario: Get detail transaction with valid parameter id
    Given User get detail on going transaction with valid id 428
    When Send request valid path detail transaction
    Then Status code 200 OK
    And response body data with valid id massage "Success get detail transaction data"
    And Validation detail transaction with valid id

  @GETTransactionPositive
  Scenario: Get detail transaction with invalid parameter id
    Given Send request valid path transaction with invalid id 700
    When Send request valid path detail transaction
    Then Status code 200 OK
    And response body data with invalid id massage "Success get detail transaction data"
    And Validation detail transaction with invalid id

  @GETTransactionPositive
  Scenario: Get detail transaction with invalid token
    Given User get detail on going transaction with valid id 428 and invalid token
    When Send request valid path detail transaction
    Then Status code 401 Unauthorized
    And response get detail transaction with invalid token massage "invalid or expired jwt"
    And Validation detail transaction with invalid token