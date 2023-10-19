Feature: Login page

  Scenario: check the login functionality
    Given halaman login
    When input username
    And input password
    And click login button
    Then user in on dashboard page

  Scenario: Failed login
    Given halaman login
    When input username
    And input invalid password
    And click login button
    Then user get error message

    Scenario: login locked
      Given halaman login
      When input username locked
      And input password
      And click login button
      Then user get error message locked