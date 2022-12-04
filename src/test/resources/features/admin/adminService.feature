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
    | 5  | Ganti Oli    |35000  |1           |