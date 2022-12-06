@ServiceVehicleCustomer
Feature: Service vehicle customer

  @GetServiceValidId
  Scenario Outline: Get all vehicle service with valid parameter id
    Given Get all vehicle service with valid id vehicle id <id>
    When Send request service
    Then Status code 200 OK
    And Response service customer body should contain massage "Success get spesific service type"
    And Validation get vehicle service with valid parameter id
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |

  @GetServiceInvalidId
  Scenario Outline: Get all Vehicle service with invalid parameter id
    Given Get all vehicle service with invalid id vehicle id <id>
    When Send request invalid path service
    Then Status code 500 Internal Server Error
    And invalid id Response customer body should contain massage "There's no ID"
    And Validation Get Vehicle service with invalid parameter id
    Examples:
      | id  |
      | 120 |
      | 130 |
      | 234 |

  @GetServiceWithoutId
  Scenario: Get Vehicle service without id
    Given Get vehicle service Without id
    When Send path service without id
    Then Status code 404 not found
    And invalid id Response body should contain massage "Not Found"
    And Validation Get Vehicle service without id

  @GetServiceWithInvalidPath
  Scenario: Get vehicle service customer with invalid path
    Given get Vehicle service with invalid path and with id 1
    When Send invalid path
    Then Status code 404 not found
    And invalid path Response body should contain massage "Not Found"
    And Validation Get vehicle service with invalid path

  @GetServiceWithInvalidToken
  Scenario: Get vehicle service customer with invalid token
    Given Vehicle service id with id 1 and invalid token
    When Send request service
    Then Status code 401 Unauthorized
    And invalid token response body should contain massage "invalid or expired jwt"
    And Validation Get Vehicle service with invalid token