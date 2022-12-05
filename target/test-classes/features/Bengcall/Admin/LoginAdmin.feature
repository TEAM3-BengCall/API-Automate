@LoginAdmin
Feature: Login admin Feature testing

  @ValidAdminLogin
  Scenario: Login Admin with valid email and password
    Given User login with file json
    When Send Request admin login
    Then Status code 202 Accepted
    And Login response body should contain full name "Admin Bengcall" role 1 massage "Success to login"
    And Validate Login succesfull json schema