#Each feature contains one feature
#Feature files use Gherkin language - business language
Feature: Test the login functionality on sdet university

#A feature may have different specific scenarios
#Scenarios use Given-When-Then structure
  Scenario: The user should be able to login with correct username and correct password
    Given user is on the login page
    When user enters correct username and correct password
    Then user gets confirmation

  Scenario Outline: the user should be able to login
    Given user is on the login page
    When user enters email <username>
    And user enters password <password>
#    And user clicks login button
    Then user gets confirmation

    Examples:

    |username            | password  |
    |tim1@testemail.com  | trpass1   |
    |tim2@testemail.com  | trpass2   |
    |tim3@testemail.com  | trpass3   |
    |tim4@testemail.com  | trpass4   |

