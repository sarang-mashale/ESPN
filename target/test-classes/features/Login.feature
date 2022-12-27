Feature: Website Login
  Scenario: Login with null inputs
    Given User is on login page of website with url "url"
    When User enters input email "null_usnm" and password "null_pass"
    And Click on login button
    Then Email required warning occur
  Scenario: Login with invalid inputs
    Given User is on login page of website with url "url"
    When User enters input email "invalid_usnm" and password "invalid_pass"
    And Click on login button
    Then Incorrect credential message occurs
  Scenario: Login with valid inputs
    Given User is on login page of website with url "url"
    When User enters input email "valid_usnm" and password "valid_pass"
    And Click on login button
    Then User is redirected to home page