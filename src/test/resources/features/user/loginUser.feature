@tugas
Feature: Login User Feature
  Scenario: Login customer with valid credential
    Given post login with valid credentials
    When send post login request with valid path
    Then Response Api should return 202 Accepted
    And Validation Json Schema Succsess Login
    And Response body  "Success to login", fullname "Ridsjfhdsajsd", role 0

    Scenario:Login customer with invalid credential
      Given post login with email field is empty
      When send post request with valid path
      Then Response Api should return 400 Bad Request
      And Validation Json Schema Login invalid
      And Response body login "password or email empty"

      Scenario: Login customer with invalid credential
        Given post login customer with Password field is empty
        When send post request with valid path
        Then Response Api should return 400 Bad Request
        And Validation Json Schema Login invalid
        And Response body "password or email empty"

        Scenario: Login customer without credentials
          Given post login customer without credentials
          When send post request with valid path
          Then Response Api should return 400 Bad Request
          And Validation Json Schema Login invalid
          And Response body "password or email empty"

          Scenario: Login new customer with invalid path
            Given post login customer with valid credentials
            When send post request with invalid path
            Then Response Api should return  404 Not Found
            And Validation Json Schema Login Not Found
            And Response body "Not Found"
