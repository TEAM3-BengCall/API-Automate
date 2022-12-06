@User
Feature: Comments User

# Scenario 1
Scenario Outline: PUT Comment user finish transaction valid id path
  Given Update comment user valid token and input id <id> and comment "<comment>"
  When Send comment user put request valid path
  Then API should return response 201 Created
  And API should return body data comment "<comment>" and  message "Success add comment"
  And Validate update comment user success to json schema
  Examples:
  | id  | comment                 |
  | 337 | Bintang 5, montir ramah |

# Scenario 2
Scenario Outline: PUT Comment user finish transaction invalid id path
  Given Update comment user valid token and input id <id> and comment "<comment>"
  When Send comment user put request valid path
  Then API should return response 500 Internal Server Error
  And API should return body message "There's no ID"
  And Validate message failed to json schema
  Examples:
    | id  | comment                 |
    | 300 | Bintang 5, montir ramah |

# Scenario 3
Scenario Outline: PUT Comment user finish transaction invalid path
  Given Update comment user valid token and input id <id> and comment "<comment>"
  When Send comment user put request invalid path
  Then API should return response 404 Not Found
  And API should return body message "Not Found"
  And Validate message failed to json schema
  Examples:
    | id  | comment                 |
    | 337 | Bintang 5, montir ramah |

# Scenario 4
  Scenario Outline: PUT Comment user finish transaction without input comment
    Given Update comment user valid token and input id <id> and comment "<comment>"
    When Send comment user put request valid path
    Then API should return response 400 Bad Request
    And API should return body message "input empty"
    And Validate message failed to json schema
    Examples:
      | id  | comment |
      | 337 |         |

# Scenario 5
  Scenario Outline: PUT Comment user finish transaction expired token
    Given Update comment user with expired token and input id <id> and comment "<comment>"
    When Send comment user put request valid path
    Then API should return response 401 Unauthorized
    And API should return body message "invalid or expired jwt"
    And Validate message failed to json schema
    Examples:
      | id  | comment                 |
      | 337 | Bintang 5, montir ramah |