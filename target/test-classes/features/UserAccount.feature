Feature: User Account
  Scenario: To test the personal information fields with valid information
    Given User is logged in on the website with credentials "sarangmashale21@gmail.com" and "aBCD.123#$"
    And User is on ESPN profile frame
    When User enters valid information in fields name "ankur" lastname "jadhav"
    And Click on Done button
    Then User is redirected to the home page
    And Updated information is displayed in user profile section
  Scenario: To test address book field in the user profile section
    Given User is logged in on the website with credentials "sarangmashale21@gmail.com" and "aBCD.123#$"
    And User is on ESPN profile frame
    And clicks add button in address book section
    When User enters the address details in the fields
    And clicks save address button
    Then address details are displayed in ESPN profile frame
