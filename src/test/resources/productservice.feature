Feature: Product
  As a user of the platform on ecommerce website
  I should be able to add, edit and remove my products' details
  Rule: I am administrator

    Scenario Outline: Add product
      Given I am logged in with status 200
      And I am on the Add product page
      When Entering  <Categories> and <description> and <status> and <Units> and <date> and <price>
      Then I should see "Product added" for product with id 4

      Examples:
        | Categories   | description    | Units | status   | date       | price |
        | "fishing"    | "fishing reel" | 120   | "new"    | "20/05/2022" | 500.00   |



    Scenario: Remove product
      Given I am logged in with status 200
      And I am on the product page with id 1
      When I try to remove product with id 1
      Then I should see "Product removed" for product with id 1


    Scenario: Edit product
      Given I am logged in with status 200
      And I am on the product page with id 2
      When I try to enable product with id 2
      Then I should see "Product enable" for product with id 2


    Scenario: Edit product
      Given I am logged in with status 200
      And I am on the product page with id 3
      When I try to disable product with id 3
      Then I should see "Product disable" for product with id 3

    Scenario: List a product given product id
      Given I am on the "ListURL" page to do a product search
      When I do a product search with the id 1
      Then I receive status code of 200 for product
      And I see a product listed result page with product id 1




    Scenario: Do a valid search
      Given I am on the homepage to do a search
      When I do a search using keyword "product 1"
      Then I receive status code of 200 for product
      And I see a search result page with product id 1