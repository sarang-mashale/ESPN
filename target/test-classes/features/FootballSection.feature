Feature: Football Section
  Scenario: To get the schedule of a team provided by user
    Given User is on home page with url "https://www.espn.in/"
    When User clicks on football button
    And clicks on teams dropdown and select a team
    And clicks on fixtures
    Then Table for scheduled matches of selected team is displayed
  Scenario: To get result of a specific match
    Given User is on home page with url "https://www.espn.in/"
    When User clicks on football button
    And clicks on teams dropdown and select a team
    And clicks on results
    Then Table for the results of selected team is displayed
  Scenario: To test the dropdowns in football section
    Given User is on home page with url "https://www.espn.in/"
    When User clicks on football button
    And clicks on teams dropdown and select a team
    And clicks on fixtures
    And select a competition from competitions dropdown
    Then Fixture for selected competition of selected team is displayed
  Scenario: To get information of world cup
    Given User is on home page with url "https://www.espn.in/"
    When User clicks on football button
    And clicks on tournaments dropdown and select FIFA World Cup
    And clicks on fixtures & results
    Then Results of latest match and schedule of upcoming match is displayed