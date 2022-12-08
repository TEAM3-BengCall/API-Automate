@vehicleAsAdmin
Feature: Admin Vehicle
  Scenario: Get Vehicle list
    Given Set get all vehicle with valid token auth
    When Send request get all vehicle
    Then Response API should return 200 OK
    And Validate all vehicle json schema
    And Json response contain "success get all vehicle"

  Scenario: Get Vehicle list with invalid token auth
    Given Set get all vehicle with invalid token auth
    When Send request get all vehicle
    Then Response API should return 401 Unauthorized
    And Validate invalid json schema
    And Json response contain "invalid or expired jwt"

  Scenario: Create new vehicle type
    Given Set create new vehicle type with valid request body
    When Send request create new vehicle type
    Then Response API should return 201 Created
    And Validate create new vehicle type json schema
    And Json response contain "Yamaha MX-King" and message "sucses add vehicle"

  Scenario: Create new vehicle type with empty value
    Given Set create new vehicle type with empty request body
    When Send request create new vehicle type
    Then Response API should return 400 Bad Request
    And Validate create invalid new vehicle type json schema
    And Json response contain "input empty"

  Scenario: Create new vehicle type with invalid token auth
    Given Set create new vehicle type with invalid token auth
    When Send request create new vehicle type
    Then Response API should return 401 Unauthorized
    And Validate create new with invalid token auth json schema
    And Json response contain "invalid or expired jwt"

  Scenario: Delete vehicle type
    Given Delete Vehicle type with valid id 1
    When Send request delete vehicle type
    Then Response API should return 202 Accepted
    And Validate delete json schema
    And Json response contain "Success delete service type"

  Scenario: Delete vehicle type with invalid auth token
    Given Delete Vehicle type with invalid auth token and valid id 1
    When Send request delete vehicle type
    Then Response API should return 401 Unauthorized
    And Validate delete json schema
    And Json response contain "invalid or expired jwt"