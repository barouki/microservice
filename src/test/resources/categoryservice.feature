Feature: Verify the product service

  Scenario: client makes call to GET category
  	Given there is a category with id=1 and name="category 1"
    When the client calls /getCategory with id=1
    Then the client receives status code of 200 for category
    And the client receives category with id=1 and name="category 1"