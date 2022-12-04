Feature: Vehicle Service
  Scenario: Get list vehicle service with valid token auth
    Given Get list vehicle service with valid token auth
    When Send request get vehicle service
    Then Response API should return 200 OK
    And Validate list vehicle service json schema
    And Json response contain "success get all vehicle + service"

  Scenario: Get list vehicle service with invalid token auth
    Given Get list vehicle service with invalid token auth
    When Send request get vehicle service
    Then Response API should return 401 Unauthorized
    And Validate invalid json schema
    And Json response contain "invalid or expired jwt"