Feature: cart page

  Scenario: add to cart
    Given user in cart page
    And user already have items in cart
    When user checkout
    Then input Firstname
    And input Lastname
    And input Postal code
    Then click continue
    Then click finish
