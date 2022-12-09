@tugas
Feature: Register Users Feature

  Scenario: Register Users with valid credential
    Given post register customer with valid credential
    When send register request with valid path
    Then Response Api should return 400 Created
    And Validation Json Schema Register succsess
    And message "already exist"

    Scenario: Register Users with password less than 8 characters
      Given post register customer with invalid password
      When send register request with valid path
      Then Response Api should return 400 Bad Request
      And Validation Json Schema Register Invalid
      And Response body  "invalid password or fullname"

      Scenario: Register Users without credentials
        Given post register customer without credentials
        When send register request with valid path
        Then Response Api should return 400 Bad Request
        And Validation Json Schema Register Invalid
        And Response body  "invalid password or fullname"

        Scenario: Register Users with invalid path
          Given post register customer with valid credential
          When send Register request with invalid path
          Then Response Api should return 404 Not Found
          And Validation Json Schema Not Found
          And Response body "Not Found"

          Scenario: Register Users with one field mandatory is empty
            Given post register customer with one field mandatory is empty
            When send register request with valid path
            Then Response Api should return 400 Bad Request
            And Validation Json Schema Register Invalid
            And Response body  "invalid password or fullname"

            Scenario: Register Users with two field mandatory is empty
              Given post register customer with two field mandatory is empty
              When send register request with valid path
              Then Response Api should return 400 Bad Request
              And Validation Json Schema Register Invalid
              And Response body "invalid password or fullname"
