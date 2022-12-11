@User
Feature: Vehicle User

#  Scenario 1
Scenario: GET vehicle type available with valid token
  Given Get vehicle type available with valid token
  When Send request get vehicle type valid path
  Then API should return response 200 OK
  And API should return body data data.id 148, data.name_vehicle "NMax" and message "success get all vehicle"
  And Validate get vehicle type available success to json schema

#Scenario 2
Scenario: GET vehicle type available with invalid path
  Given Get vehicle type available with valid token
  When Send request get vehicle type invalid path
  Then API should return response 404 Not Found
  And API should return body message "Not Found"
  And Validate message failed to json schema

#Scenario 3
  Scenario: GET vehicle type available with expired token
    Given Get vehicle type available with expired token
    When Send request get vehicle type valid path
    Then API should return response 401 Unauthorized
    And API should return body message "invalid or expired jwt"
    And Validate message failed to json schema