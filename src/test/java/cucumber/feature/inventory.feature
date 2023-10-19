Feature: inventory page

  Scenario: check product detail
    Given user already logged in
    When user in inventory page
    Then user click an item

  Scenario: add to cart
    Given user already logged in
    When user in inventory page
    Then user click add to cart

#  Scenario: remove from cart
#    Given user already logged in
#    When user in inventory page
#    Then user click add to cart
#    And user click remove