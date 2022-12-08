@loginAsAdmin
Feature: Service As Admin
  Scenario Outline: Get view all service information with valid id
    Given Set view all service information as admin with valid token and <id>
    When Send request get all service information
    Then Response API should return 200 OK
    And Validate json schema
    And Json response contain message "Success get spesific service type"
    Examples:
    | id |
    | 1  |

  Scenario Outline: Get view all service information with invalid id
    Given Set view all service information as admin with invalid <id>
    When Send request get invalid service information
    Then Response API should return 500 Internal Server Error
    And Validate invalid json schema
    And Json response contain message "id not valid"
    Examples:
    | id  |
    | ^&* |

  Scenario Outline: Create new service type with valid data
    Given Set create new service with valid request body
    When Send request create new service
    Then Response API should return 201 Created
    And Validate creat new service type json schema
    And Json response contain <id>  <service_name>  <price>  <vehicle_id>
    Examples:
    | id | service_name | price | vehicle_id |
    | 5  | Ganti Oli    | 35000 | 1          |

  Scenario: Create new service type with empty value on vehicle id
    Given Set create new service with request body empty vehicle id value
    When Send request create new service
    Then Response API should return 400 Bad Request
    And Validate invalid create json schema
    And Json response contain "cannot bind input"

  Scenario: Create new service type with empty value on service name
    Given Set create new service with request body empty service name value
    When Send request create new service
    Then Response API should return 400 Bad Request
    And Validate invalid create json schema
    And Json response contain "there's input empty"

  Scenario: Create new service type with empty value on price
    Given Set create new service with request body empty price value
    When Send request create new service
    Then Response API should return 400 Bad Request
    And Validate invalid create json schema
    And Json response contain "cannot bind input"

  Scenario: Create new service type with empty value
    Given Set create new service with empty request body
    When Send request create new service
    Then Response API should return 400 Bad Request
    And Validate invalid create json schema
    And Json response contain "there's input empty"

  Scenario Outline: Delete Service Type with valid parameter id
    Given Set delete service type with valid parameter <id>
    When Send request delete service type
    Then Response API should return 202 Accepted
    And Validate delete json schema
    And Json response contain "Success delete service type"
    Examples:
      | id |
      |1   |

  Scenario: Delete Service Type with invalid parameter id
    Given Set delete service type with invalid parameter
    When Send request delete service type without parameter
    Then Response API should return 405 Method Not Allowed
    And Validate delete json schema
    And Json response contain "Method Not Allowed"
