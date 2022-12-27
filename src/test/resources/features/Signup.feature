Feature: Website Sign up
  Scenario: Sign up with invalid inputs
    Given User is on signup page of website with url "https://www.espn.in/"
    When User enters inputs first name "Veer" last name "Suryavanshi" email "sarangmashale21@gmail" and password "PSL@cynicsveer.123"
    And Click on sign up button
    Then warning occurs under email field
  Scenario: Sign up with null inputs
    Given User is on signup page of website with url "https://www.espn.in/"
    When User enters inputs first name " " last name " " email " " and password " "
    And Click on sign up button
    Then warning occurs below every field
  Scenario: Sign up with valid inputs
    Given User is on signup page of website with url "https://www.espn.in/"
    When User enters inputs first name "Veer" last name "Suryavanshi" email "sarangmashale21@gmail.com" and password "Vaishali@12"
    And Click on sign up button
    Then User is redirected to ESPN home page