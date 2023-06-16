Feature: Homework Functionality

  Scenario:To check Homework Functionality is working or not.
    Given User is on dashboard page
    When User clicks on Homework Menu
    Then User is redirect on Homework page
    Given User is on Homework page
    When User clicks on Add Homework button
    And User fills up all the required fields
    And User clicks on Submit button
    Then Added details are display
    Given User is on the Homework page
    When User clicks on the Edit button
    And User update the data
    Then Updated data is display
    Given User is on to the homework page
    When User click on view menu
    Then Homework page is display
    Given user is on to homework page
    When User clicks on Delete menu
    Then Homework is deleted
    Given User is in the Homework page
    When User clicks on the Add Homework button
    And User clicks on the Submit button
    Then Validation is display