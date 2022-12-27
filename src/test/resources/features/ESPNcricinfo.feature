Feature: ESPN Cricinfo
  Scenario: To test dropdown funtionality on ESPN Cricinfo website
    Given User is on home page of ESPN website with url "https://www.espn.in/"
    And User clicks on ESPN Cricinfo Button in apps section
    And User is redirected to ESPN Cricinfo website
    When User click on teams dropdown and select India
    Then User is redirected to the page having results of Indian team
  Scenario: To get result of specific team
    Given User is on home page of ESPN website with url "https://www.espn.in/"
    And User clicks on ESPN Cricinfo Button in apps section
    And User is redirected to ESPN Cricinfo website
    When User click on teams dropdown and select New Zealand
    And User is redirected to the page having results of New Zealand team
    And User clicks on the result button present on home tab
    Then Results of the selected team is displayed
  Scenario: To get the data from the tables present on website.
    Given User is on home page of ESPN website with url "https://www.espn.in/"
    And User clicks on ESPN Cricinfo Button in apps section
    And User is redirected to ESPN Cricinfo website
    When User clicks on Bangladesh v India series in key series panel
    And select fixtures and results on redirected page
    And click on third ODI match
    Then User is redirected to Full scorecard page for the selected match
    And Table with data of players is displayed
  #Scenario: To test the search functionality of the ESPNCricinfo website
    #Given User is on home page of ESPN website with url "https://www.espn.in/"
    #And User clicks on ESPN Cricinfo Button in apps section
    #And User is redirected to ESPN Cricinfo website
    #When User clicks on search button on
