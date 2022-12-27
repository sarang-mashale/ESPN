Feature: Search Funtionality
  Scenario: To search a player by name and validate results
    Given User is on ESPN home page with url "https://www.espn.in/"
    And Search button is clicked
    When User enters input name "Virat Kohli"
    And press enter key
    Then Player card for the searched player is displayed