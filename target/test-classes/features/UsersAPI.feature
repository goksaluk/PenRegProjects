
@users
Feature: Users API Test

  Background:
    Given I set REST API url


  Scenario Outline: verify user from users API
    Then I send the request to "users_endpoint" with page 2
    Then status code should be 200
    And I get the list of Users
    Then verify that related "<id>" have below "<first_name>" , "<last_name>" and "<avatar>"

    Examples:
      | id | first_name | last_name | avatar                                  |
      | 7  | Michael    | Lawson    | https://reqres.in/img/faces/7-image.jpg |
    # | 8  | Lindsay    | Ferguson  | https://reqres.in/img/faces/8-image.jpg |

