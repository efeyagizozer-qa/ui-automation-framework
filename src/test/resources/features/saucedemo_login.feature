Feature: SauceDemo Login

  Scenario: Successful login with valid credentials
    Given user is on SauceDemo login page
    When user enters valid username and password
    And user clicks login button
    Then user should see inventory page

