Feature: Emi Calculator

  @RegressionTesting
  Scenario: Car Loan
    Given User selects car loan in the application
    When Users enters the values to compute the emi
    Then The Emi is displayed is compared with the computed one

  @RegressionTesting
  Scenario: Home Loan
    Given The user navigates to the Home Loan page
    When The user enters the values
    And Emi is calculated
    And Year on year table is displayed is saved in an excel

  @RegressionTesting
  Scenario: Checking UI Functionality
    Given The user navigates to Loan page
    Then User do all the neccessary UI Functionality
    And User selects Loan amount calculator to do all the neccessary UI Functionality
    And User selects Loan Tenure Calculator to do all the neccessary UI Functionality

  @SmokeTesting
  Scenario: Smoke Testing
    Given Car loan page is clicked
    And Home Loan page is clicked
    And Emi calaculator page is clicked
    And Loan Amount calculator page is clicked
    Then Loan Tenure calculator page is clicked
