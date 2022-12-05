@LoginAdmin
Feature: Login admin Feature testing

  @ValidAdminLogin
  Scenario: Login Admin with valid email and password
    Given User login with valid data file json
    When Send Request admin login
    Then Status code 202 Accepted
    And Login response body should contain full name "Admin Bengcall" role 1 massage "Success to login"
    And Validate Login successful json schema


  @InvalidAdminLogin
  Scenario: Login Admin with invalid email and password
    Given User login with invalid data file json
    When Send Request admin login
    Then Status code 400 Bad request
    And Response body should contain massage "email not found"
    And Validate Login admin unsucess json schema

  @LoginAdminInvalidPath
  Scenario: Login Admin With Invalid path
    Given User login with valid data file json
    When Send Request invalid path admin login
    Then Status code 404 not found
    And invalid path Response body should contain massage "Not Found"
    And Validate login admin invalid path

  @loginAdminWihoutEmail
  Scenario: Login Admin Without Email
    Given Json File body Without email
    When Send Request admin login
    Then Status code 400 Bad request
    And response body without email should contain massage "password or email empty"
    And Validate json path without email
    
  @loginAdminWithoutPassword
  Scenario: Login admin Without Password
    Given Json File body Without password
    When Send Request admin login
    Then Status code 400 Bad request
    And response body without password should contain massage "password or email empty"
    And Validate json path without password