Feature: NBA Section
  Scenario: To get the fixtures of a specific team
    Given User is on home page of website with url "https://www.espn.in/"
    When User clicks on NBA button
    And clicks on teams and select team
    And clicks on schedule button
    Then Upcoming match schedule is displayed
  Scenario: To get result of a matches
    Given User is on home page of website with url "https://www.espn.in/"
    When User clicks on NBA button
    Then Result of latest match is displayed on home page of NBA section
  Scenario: To get information of a specific team (standing and results) provided by user
    Given User is on home page of website with url "https://www.espn.in/"
    When User clicks on NBA button
    And clicks on teams and select team
    And clicks on schedule button
    Then results of selected team is displayed
