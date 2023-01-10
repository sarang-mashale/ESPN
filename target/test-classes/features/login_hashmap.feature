Feature: Website Login using hashmap
  Scenario: Login with null inputs using hashmap
    Given User is on login page with url "url"
    When User enters email "null_usnm" and password "null_pass"
    And Clicks login button
    Then Email required warning is displayed
  Scenario: Login with invalid inputs using hashmap
    Given User is on login page with url "url"
    When User enters email "invalid_usnm" and password "invalid_pass"
    And Clicks login button
    Then Invalid Creds
  Scenario: Login with valid inputs using hashmap
    Given User is on login page with url "url"
    When User enters email "valid_usnm" and password "valid_pass"
    And Clicks login button
    Then Success