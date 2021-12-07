Feature: Ebay Home Page

  @P11
  Scenario: Advanced Search Link
    Given I am on Ebay Home Page
    When I click on Advanced Link
    Then I Navigate to Advanced Search Page

  @P12 @chkBefore @chkAfter
  Scenario: Search iphone13 Items Count
    Given I am on Ebay Home Page
    When I search for 'iphone 13'
    Then I validate atleast 1000 search items

  @P13
  Scenario: Search Garnier Items Count
    Given I am on Ebay Home Page
    When I search for 'Garnier'
    Then I validate atleast 500 search items

  @P14
  Scenario: Search an item in Category
    Given I am on Ebay Home Page
    When I search for 'Soap' in 'Baby' Category

  @P15
  Scenario Outline: Home Page Links
    Given I am on Ebay Home Page
    When I click on '<link>'
    Then I validate that page navigates to '<url>' and title contains '<title>'

    Examples: 
      | link    | url                                                            | title       |
      | Motors  | https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334 | eBay Motors |
      | Fashion | https://www.ebay.com/b/Fashion/bn_7000259856                   | Fashion     |
      | Toys    | https://www.ebay.com/b/Toys-Hobbies/220/bn_1865497             | Toys        |
