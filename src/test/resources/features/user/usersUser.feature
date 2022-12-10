@User
Feature: User Profile

#  Scenario 1
Scenario: GET user profile with valid token
  Given Get user profile with valid token
  When Send request get customer user profile valid path
  Then API should return response 200 OK
  And API should return body data fullname "Destiana Ayu", images "https://bengcallbucket.s3.ap-southeast-1.amazonaws.com/profile/Q5aWl5c2RKoHcIFIrbMi-dummy450x450.jpg", email "destiana@gmail.com" and message "success get my profile"
  And Validate get user profile success to json schema

#  Scenario 2
Scenario: GET  user profile with expired token
  Given Get user profile with expired token
  When Send request get customer user profile valid path
  Then API should return response 401 Unauthorized
  And API should return body message "invalid or expired jwt"
  And Validate message failed to json schema

#  Scenario 3
Scenario: GET  user profile with invalid path
  Given Get user profile with valid token
  When Send request get customer user profile invalid path
  Then API should return response 404 Not Found
  And API should return body message "Not Found"
  And Validate message failed to json schema

#  Scenario 4
Scenario Outline: PUT User profile valid body data
  Given Update user profile valid token and input fullname "<fullname>", email "<email>" and image
  When Send update user put request valid path
  Then API should return response 202 Accepted
  And API should return body data fullname "<fullname>", email "<email>" and  message "success update user"
  And Validate update user profile success to json schema
  Examples:
    | fullname           | email              |
    | Destiana Ayu Aulia | destiana@gmail.com |

#  Scenario 5
  Scenario: PUT User profile without body data
    Given Update user profile without input body data
    When Send update user put request valid path
    Then API should return response 400 Bad Request
    And API should return body message "please insert one field"
    And Validate message failed to json schema

#  Scenario 6
  Scenario Outline: PUT User profile without body data
    Given Update user profile valid token and input fullname "<fullname>", email "<email>" and image
    When Send update user put request invalid path
    Then API should return response 404 Not Found
    And API should return body message "Not Found"
    And Validate message failed to json schema
  Examples:
    | fullname           | email              |
    | Destiana Ayu Aulia | destiana@gmail.com |

#  Scenario 7
  Scenario: PUT User profile with expired token
    Given Update user profile with expired token
    When Send update user put request valid path
    Then API should return response 401 Unauthorized
    And API should return body message "invalid or expired jwt"
    And Validate message failed to json schema

#  Scenario 8
  Scenario: DELETE user profile with valid token
    Given Delete user profile with valid token
    When Send request delete user profile valid path
    Then API should return response 202 Accepted
    And API should return body message "Success deactivate account"
    And Validate delete user profile success to json schema

#  Scenario 9
  Scenario: DELETE user profile with invalid path
    Given Delete user profile with valid token
    When Send request delete user profile invalid path
    Then API should return response 404 Not Found
    And API should return body message "Not Found"
    And Validate message failed to json schema

#  Scenario 10
  Scenario: DELETE user profile with expired token
    Given Delete user profile with expired token
    When Send request delete user profile valid path
    Then API should return response 401 Unauthorized
    And API should return body message "invalid or expired jwt"
    And Validate message failed to json schema