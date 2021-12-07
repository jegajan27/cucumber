Feature: Ebay Advanced Search Page

  @P21
  Scenario: Ebay Logo on Advanced Search Page
    Given I am on Ebay Advanced Search Page
    When I click on Ebay Logo
    Then I navigate to Ebay Home Page

  @P22
  Scenario: Advanced Search an item
    Given I am on Ebay Advanced Search Page
    When I Advanced Search an item
      | keyword   | exclude     | min | max |
      | iphone 11 | refurbished | 300 | 900 |
     
   